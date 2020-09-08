package src.WordPattern;

import java.util.HashMap;

/**
 * @author mingqiao
 * @Date 2020/9/8
 */
public class WordPattern {

    /**
     * 模拟一下
     *
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }
        String[] string = str.split(" ");
        if (pattern.length() != string.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char tmp = pattern.charAt(i);
            if (map.containsKey(tmp)) {
                if (!map.get(tmp).equals(string[i])) {
                    return false;
                }
            } else {
                //不能两个string映射同一个Character
                if (map.containsValue(string[i])) {
                    return false;
                } else {
                    map.put(tmp, string[i]);
                }
            }
        }
        return true;
    }
}
