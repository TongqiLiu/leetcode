package src.WordLadderII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

/**
 * @author mingqiao
 * @Date 2020/2/25
 */
public class WordLadderII {

    /**
     * 先反向bfs计算出达到字典里每个单词的最短距离，再正向dfs出所有结果复杂度O(N ^ 2)
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> results = new ArrayList<>();

        Set<String> dict = new HashSet<>();
        dict.addAll(wordList);
        if (!dict.contains(endWord)) {
            return new ArrayList<>();
        }
        dict.add(beginWord);

        Map<String, Integer> disMap = new HashMap<>();
        bfs(endWord, beginWord, dict, disMap);
        dfs(results, new ArrayList<String>() {{
            add(beginWord);
        }}, beginWord, endWord, dict, disMap);
        return results;
    }

    private void dfs(List<List<String>> results, List<String> subsets, String cur, String endWord,
                     Set<String> dict, Map<String, Integer> disMap) {
        if (cur.equals(endWord)) {
            results.add(new ArrayList<>(subsets));
        }

        for (String next : getNextWord(cur, dict)) {
            if (disMap.get(cur) == disMap.get(next) + 1) {
                subsets.add(next);
                dfs(results, subsets, next, endWord, dict, disMap);
                subsets.remove(next);
            }
        }
    }

    private void bfs(String beginWord, String endWord, Set<String> dict, Map<String, Integer> disMap) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        disMap.put(beginWord, 0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String next : getNextWord(word, dict)) {
                    if (disMap.containsKey(next)) {
                        continue;
                    }

                    disMap.put(next, disMap.get(word) + 1);
                    queue.add(next);
                }
            }
        }
    }

    private List<String> getNextWord(String word, Set<String> dict) {
        List<String> list = new ArrayList<>();
        char[] ch = word.toCharArray();
        char[] tmp = Arrays.copyOf(ch, ch.length);

        //枚举该单词能转化到的下一个单词
        for (int i = 0; i < word.length(); i++) {
            for (char w = 'a'; w <= 'z'; w++) {
                if (ch[i] == w) {
                    continue;
                }

                tmp[i] = w;
                String str = new String(tmp);
                if (dict.contains(str)) {
                    list.add(str);
                }
                tmp[i] = ch[i];
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
