package src.ShortestWordDistanceII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mingqiao
 * @Date 2020/3/2
 */
public class ShortestWordDistanceII {

    private Map<String, List<Integer>> map;

    public ShortestWordDistanceII(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int finalI = i;
            map.merge(words[i], new ArrayList<Integer>() {{
                    add(finalI);
                }},
                (pre, one) -> {
                    pre.addAll(one);
                    return pre;
                });
        }
    }

    /**
     * hashMap预处理出每个字符串在的位置
     *
     * @param word1
     * @param word2
     * @return
     */
    public int shortest(String word1, String word2) {
        List<Integer> word1List = map.get(word1);
        List<Integer> word2List = map.get(word2);
        int res = Integer.MAX_VALUE;
        for (int i : word1List) {
            for (int j : word2List) {
                res = Math.min(res, Math.abs(i - j));
            }
        }
        return res;
    }
}
