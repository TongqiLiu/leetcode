package src.PatternMatchingLCCI;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mingqiao
 * @Date 2020/7/29
 */
public class PatternMatchingLCCI {

    private Map<Character, String> map = new HashMap<>();

    /**
     * 题目链接：https://leetcode-cn.com/problems/pattern-matching-lcci/
     * map存储字母->模式串的映射，枚举每个位置
     *
     * @param pattern
     * @param value
     * @return
     */
    public boolean patternMatching(String pattern, String value) {
        //bad case特判
        if (pattern.length() == 0 && value.length() == 0) {
            return true;
        } else if (pattern.length() == 0) {
            return false;
        }

        char c = pattern.charAt(0);
        if (map.containsKey(c)) {
            String s = map.get(c);
            if (s.length() > value.length()) {
                return false;
            }
            if (value.substring(0, s.length()).equals(s)) {
                return patternMatching(pattern.substring(1), value.substring(s.length()));
            }
        } else {
            //枚举value每个位置可能形成的模式串
            for (int i = 0; i <= value.length(); i++) {
                String s = value.substring(0, i);
                if (map.containsValue(s)) {
                    continue;
                }

                map.put(c, s);
                if (patternMatching(pattern.substring(1), value.substring(i))) {
                    return true;
                }
            }
            map.remove(c);
        }
        return false;
    }
}
