package src.DesignSearchAutoCompleteSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/10/10
 */
public class DesignSearchAutoCompleteSystem {

    private Trie trie;

    public DesignSearchAutoCompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        for (int i = 0; i < sentences.length; i++) {
            for (int j = 0; j < times[i]; j++) {
                trie.insert(sentences[i]);
            }
        }
    }

    public List<String> input(char c) {
        return trie.hotSearch(c);
    }
}

class Trie {

    private TrieNode root;
    private StringBuilder sb;

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

        //单词出现个数
        private int wordNum;

        private final int SIZE = 27;

        TrieNode(int val) {
            num = 1;
            wordNum = 0;
            index = val;
            son = new TrieNode[SIZE];
            isEnd = false;
        }
    }

    private class Sentence implements Comparable<Sentence> {
        public int wordNum;
        public String word;

        public Sentence(int wordNum, String word) {
            this.wordNum = wordNum;
            this.word = word;
        }

        @Override
        public int compareTo(Sentence o) {
            //按数目及字典序排序
            if (this.wordNum == o.wordNum) {
                return this.word.compareTo(o.word);
            }
            return o.wordNum - this.wordNum;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode(-1);
        sb = new StringBuilder();
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
            int index = ch == ' ' ? 26 : ch - 'a';
            if (curNode.son[index] == null) {
                curNode.son[index] = new TrieNode(index);
            } else {
                curNode.son[index].num++;
            }
            curNode = curNode.son[index];
        }
        curNode.isEnd = true;
        curNode.word = word;
        curNode.wordNum++;
    }

    /**
     * 热度搜索
     *
     * @param c
     * @return
     */
    public List<String> hotSearch(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            this.insert(sb.toString());
            sb = new StringBuilder();
            return res;
        }

        //找到该输入前缀
        sb.append(c);
        TrieNode cur = root;
        for (int i = 0; i < sb.length(); i++) {
            int idx = sb.charAt(i) == ' ' ? 26 : sb.charAt(i) - 'a';
            if (cur.son[idx] == null) {
                return res;
            }
            cur = cur.son[idx];
        }

        //dfs找到单词集合
        List<Sentence> queue = new LinkedList<>();
        dfs(queue, cur);
        Collections.sort(queue);

        int cnt = queue.size() > 3 ? 3 : queue.size();
        for (int i = 0; i < cnt; i++) {
            res.add(queue.get(i).word);
        }
        return res;
    }

    /**
     * 遍历所有可能出现的单词
     *
     * @param queue
     * @param node
     */
    public void dfs(List<Sentence> queue, TrieNode node) {
        if (node.isEnd) {
            queue.add(new Sentence(node.wordNum, node.word));
        }
        for (int i = 0; i < node.SIZE; i++) {
            if (node.son[i] != null) {
                dfs(queue, node.son[i]);
            }
        }
    }

}
