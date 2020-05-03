package src.WordLadder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import javafx.util.Pair;

/**
 * @author mingqiao
 * @Date 2020/2/24
 */
public class WordLadder {

    private boolean canChange(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private int bfs(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(beginWord, 1));
        Set<String> vis = new HashSet<>();

        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String curWord = pair.getKey();
            Integer times = pair.getValue();
            if (curWord.equals(endWord)) {
                return times;
            }

            for (String word : wordList) {
                if (!vis.contains(word) && canChange(curWord, word)) {
                    vis.add(word);
                    queue.offer(new Pair<>(word, times + 1));
                }
            }
        }
        return 0;
    }

    /**
     * bfs，最坏复杂度O(length * N)，这里也可以使用双向bfs进行优化
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return bfs(beginWord, endWord, wordList);
    }
}
