package src.WordSquares;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/3/10
 */
public class WordSquares {

    private List<List<String>> ans = new ArrayList<>();

    /**
     * 比如例子中的：
     * b a l l
     * a r e a
     * l e a d
     * l a d y
     *
     * 新增单词的前缀由它前面单词对角线字母组合而成，故我们通过trie完成前缀单词匹配，dfs搜出所有解法
     *
     * @param words
     * @return
     */
    public List<List<String>> wordSquares(String[] words) {
        ans.clear();
        if (words == null || words.length == 0) {
            return ans;
        }
        int n = words[0].length();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        dfs(trie.root, trie.root, n, new char[n][n], new ArrayList<>(), 0, 0);
        return ans;
    }

    private void dfs(TrieNode root, TrieNode node, int n, char[][] board, List<String> path, int x, int y) {
        if (x == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (y == n && node.isEnd) {
            //新的一行开始从头匹配
            path.add(node.word);
            dfs(root, root, n, board, path, x + 1, 0);
            path.remove(path.size() - 1);
            return;
        }

        //已确定的前缀能够在字典里找到，比如第一个单词填了ball后，第二个单词就固定a字母起始
        if (y < x) {
            TrieNode child = node.son[board[x][y] - 'a'];
            //System.out.println("x:" + x + ", y:" + y + ", board:" + Arrays.deepToString(board));
            if (child != null) {
                dfs(root, child, n, board, path, x, y + 1);
            }
            return;
        }

        //字典里可能存在的字符串结果集
        TrieNode[] son = node.son;
        for (TrieNode child : son) {
            if (child == null) {
                continue;
            }
            board[x][y] = board[y][x] = (char)('a' + child.index);
            dfs(root, child, n, board, path, x, y + 1);
        }
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
