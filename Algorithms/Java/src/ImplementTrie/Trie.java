package src.ImplementTrie;

/**
 * @author mingqiao
 * @Date 2020/3/9
 */
public class Trie {

    private TrieNode root;

    private class TrieNode {
        //通过该节点的单词数
        private int num;

        //节点自身的值
        private int index;

        //儿子结点集合
        private TrieNode[] son;

        // 是不是最后一个节点
        private boolean isEnd;

        //单词
        private String word;

        private final int SIZE = 26;

        TrieNode(int val) {
            num = 1;
            index = val;
            son = new TrieNode[SIZE];
            isEnd = false;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode(-1);
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode curNode = root;
        for (char ch : chars) {
            int index = ch - 'a';
            if (curNode.son[index] == null) {
                curNode.son[index] = new TrieNode(index);
            } else {
                curNode.son[index].num++;
            }
            curNode = curNode.son[index];
        }
        curNode.isEnd = true;
        curNode.word = word;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        char[] chars = word.toCharArray();
        TrieNode curNode = root;
        for (char ch : chars) {
            int index = ch - 'a';
            if (curNode.son[index] == null) {
                return false;
            }
            curNode = curNode.son[index];
        }
        return curNode.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        char[] chars = prefix.toCharArray();
        TrieNode curNode = root;
        for (char ch : chars) {
            int index = ch - 'a';
            if (curNode.son[index] == null) {
                return false;
            }
            curNode = curNode.son[index];
        }
        return true;
    }
}
