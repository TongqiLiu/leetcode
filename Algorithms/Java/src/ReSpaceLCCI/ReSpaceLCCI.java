package src.ReSpaceLCCI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mingqiao
 * @Date 2020/8/19
 */
public class ReSpaceLCCI {

    /**
     * 题目链接：https://leetcode-cn.com/problems/re-space-lcci/
     * dp[i]表示到i位置最少的未匹配数，复杂度O(N ^ 2)
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public int respace(String[] dictionary, String sentence) {
        if (dictionary == null || dictionary.length == 0) {
            return 0;
        }
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int n = sentence.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            //第i位置不匹配
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                //如果子串能在字典中找到，则可转移
                if (set.contains(sentence.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[n];
    }

    /**
     * 建树用字典树可以进行查询优化，理论复杂度O(N ^ 2 + M)，但出现每个单词都需转移的概率较低，故实际耗时少
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public int respace1(String[] dictionary, String sentence) {
        if (dictionary == null || dictionary.length == 0) {
            return 0;
        }
        int n = sentence.length();
        Trie trie = new Trie();
        for (String word : dictionary) {
            //倒序插入
            trie.insert(new StringBuffer(word).reverse().toString());
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            //找到字典树中能匹配的单词进行转移
            List<Integer> posList = trie.searchPos(sentence, i - 1);
            if (posList != null && posList.size() > 0) {
                for (int pos : posList) {
                    dp[i] = Math.min(dp[i], dp[pos]);
                }
            }
        }
        return dp[n];
    }

    private class Trie {

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

        /**
         * Returns if the word is in the trie.
         */
        public List<Integer> searchPos(String word, int endPos) {
            if (word == null || word.length() == 0) {
                return null;
            }
            List<Integer> res = new ArrayList<>();
            char[] chars = word.toCharArray();
            TrieNode curNode = root;
            for (int i = endPos; i >= 0; i--) {
                char ch = chars[i];
                int index = ch - 'a';
                if (curNode.son[index] == null) {
                    break;
                }
                curNode = curNode.son[index];
                if (curNode.isEnd) {
                    res.add(i);
                }
            }
            return res;
        }
    }
}


