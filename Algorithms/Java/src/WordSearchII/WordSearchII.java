package src.WordSearchII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mingqiao
 * @Date 2020/3/12
 */
public class WordSearchII {

    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private Set<String> set = new HashSet<>();

    /**
     * 字典树保存所有单词并用来做dfs时的剪枝
     *
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        set.clear();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                search(board, vis, i, j, n, m, trie.root);
            }
        }
        return new ArrayList<>(set);
    }

    private void search(char[][] board, boolean[][] vis,
                        int x, int y, int n, int m, TrieNode node) {
        if (x < 0 || y < 0 || x >= n || y >= m || vis[x][y]) {
            return;
        }

        node = node.son[board[x][y] - 'a'];
        if (node == null) {
            return;
        }
        //搜索到了该单词
        if (node.isEnd && node.word != null) {
            set.add(node.word);
        }

        vis[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + d[i][0];
            int ny = y + d[i][1];
            search(board, vis, nx, ny, n, m, node);
        }
        vis[x][y] = false;
    }

    private class TrieNode {
        //通过该节点的单词数
        private int num;

        //节点自身的值
        private int index;

        //儿子结点集合
        private TrieNode[] son;

        //是不是最后一个节点
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

    public class Trie {

        private TrieNode root;

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
}
