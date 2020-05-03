package src.WordBreakII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javafx.util.Pair;

/**
 * @author mingqiao
 * @Date 2020/2/29
 */
public class WordBreakII {

    /**
     * 记忆化搜索，map存放当前位置开始的字符串可能组成结果的句子，复杂度O(N ^ 3)
     *
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, new HashSet<>(wordDict), new HashMap<>());
    }

    private List<String> dfs(String s, Set<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (s.isEmpty()) {
            return null;
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i);
            if (wordDict.contains(str)) {
                List<String> suffixRes = dfs(s.substring(0, i), wordDict, map);
                //直接匹配到末尾
                if (suffixRes == null) {
                    res.add(str);
                } else {
                    for (String suffix : suffixRes) {
                        res.add(suffix + " " + str);
                    }
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
