package src.IsomorphicStrings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tongqi
 * @date 2025/12/28
 */
public class IsomorphicStrings {

    /**
     * 判断两个字符串是否同构
     * 
     * @param s 第一个字符串
     * @param t 第二个字符串
     * @return 如果两个字符串同构返回true，否则返回false
     */
    public boolean isIsomorphic(String s, String t) {
       
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}

