package src.WordPatternII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mingqiao
 * @Date 2020/9/8
 */
public class WordPatternII {

    private Map<Character, String> map = new HashMap<>();

    /**
     * 延续上题的思路，依然使用Map保存映射关系，然后对子串进行枚举递归
     *
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }

        char ch = pattern.charAt(0);
        for (int i = 1; i <= str.length() - pattern.length() + 1; i++) {
            String sub = str.substring(0, i);
            String mapStr = map.get(ch);

            if (mapStr != null && !sub.equals(mapStr)) {
                continue;
            }
            if (mapStr == null && map.containsValue(sub)) {
                continue;
            }

            //已有映射 或 无映射且无抢占可尝试
            if (mapStr == null) {
                map.put(ch, sub);
            }
            if (wordPatternMatch(pattern.substring(1), str.substring(i))) {
                return true;
            }
            if (mapStr == null) {
                map.remove(ch);
            }
        }
        return false;
    }
}
