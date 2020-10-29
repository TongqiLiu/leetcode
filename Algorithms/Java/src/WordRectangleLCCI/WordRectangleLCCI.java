package src.WordRectangleLCCI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author mingqiao
 * @Date 2020/10/28
 */
public class WordRectangleLCCI {

    private Map<Integer, Set<String>> wordMap;
    private List<String> ans;
    private int maxArea;
    private int maxLen;
    private Trie trie;

    public String[] maxRectangle(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        wordMap = new HashMap<>();
        ans = new ArrayList<>();
        maxArea = 0;
        maxLen = 0;

        trie = new Trie();
        for (String word : words) {
            trie.insert(word);

            maxLen = Math.max(word.length(), maxLen);
            wordMap.merge(word.length(), new HashSet<String>() {{
                add(word);
            }}, (pre, one) -> {
                pre.addAll(one);
                return pre;
            });
        }

        for (Entry<Integer, Set<String>> entry : wordMap.entrySet()) {
            Integer wordLen = entry.getKey();
            Set<String> wordSet = entry.getValue();
            dfs(wordSet, wordLen, new ArrayList<>());
        }
        return ans.toArray(new String[] {});
    }

    public void dfs(Set<String> wordSet, int wordLen, List<String> path) {
        //单词数量超出最长单词长度
        if (path.size() > maxLen) {
            return;
        }
        //剪枝
        if (wordLen * maxLen <= maxArea) {
            return;
        }

        for (String word : wordSet) {
            path.add(word);

            boolean[] res = trie.isValid(path);

            //是否目前集合单词前缀都在字典集中
            if (res[0]) {
                //是否集合单词均已在字典集中
                if (res[1]) {
                    int area = path.size() * path.get(0).length();

                    if (area > maxArea) {
                        maxArea = area;
                        ans = new ArrayList<>(path);
                    }
                }

                dfs(wordSet, wordLen, path);
            }

            path.remove(path.size() - 1);
        }
    }

    class Trie {

        private TrieNode root;
        private final int SIZE = 26;

        private class TrieNode {
            //通过该节点的单词数
            private int num;

            //节点自身的值
            private int index;

            //儿子结点集合
            private TrieNode[] son;

            // 是不是最后一个节点
            private boolean isEnd;

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
         * 判断矩阵中的每一列形成的单词都在清单里
         * 返回结果分别表示：是否有单词前缀不在字典树中，是否所有列都已经构成了单词
         *
         * @param path
         * @return
         */
        public boolean[] isValid(List<String> path) {
            boolean[] res = new boolean[2];
            boolean flag = true;
            int n = path.size();
            int m = path.get(0).length();

            //按列check是否有单词前缀不在字典树中
            for (int j = 0; j < m; j++) {
                TrieNode node = this.root;

                for (int i = 0; i < n; i++) {
                    int index = path.get(i).charAt(j) - 'a';
                    if (node.son[index] == null) {
                        return new boolean[] {false, false};
                    }
                    node = node.son[index];
                }
                if (!node.isEnd) {
                    flag = false;
                }
            }
            return new boolean[] {true, flag};
        }
    }
}