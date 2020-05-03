package src.AddAndSearchWord;

/**
 * @author mingqiao
 * @Date 2020/3/11
 */
public class WordDictionary {

    private Trie trie;

    /**
     * 题目地址：https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/
     * 字典树前缀匹配，如果碰到.字符则递归遍历所有当前节点的子节点
     */
    public WordDictionary() {
        trie = new Trie();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        trie.insert(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return trie.search(word);
    }

    public class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode(-1);
        }

        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }

            char[] chars = word.toCharArray();
            TrieNode node = root;
            for (char ch : chars) {
                int index = ch - 'a';
                if (node.son[index] == null) {
                    node.son[index] = new TrieNode(index);
                } else {
                    node.son[index].num++;
                }
                node = node.son[index];
            }
            node.isEnd = true;
            node.word = word;
        }

        public boolean dfs(TrieNode root, String word, int pos) {
            if (pos == word.length()) {
                return root.isEnd;
            }
            char ch = word.charAt(pos);
            if (ch != '.') {
                int index = ch - 'a';
                if (root.son[index] != null) {
                    return dfs(root.son[index], word, pos + 1);
                }
                return false;
            } else {
                for (TrieNode child : root.son) {
                    if (child != null && dfs(child, word, pos + 1)) {
                        return true;
                    }
                }
                return false;
            }
        }

        public boolean search(String word) {
            return dfs(root, word, 0);
        }
    }

    public class TrieNode {

        private final int size = 26;

        private int index;
        private Boolean isEnd;
        private int num;
        private String word;
        private TrieNode[] son;

        TrieNode(int index) {
            this.index = index;
            this.isEnd = false;
            this.num = 1;
            this.word = null;
            this.son = new TrieNode[size];
        }
    }
}
