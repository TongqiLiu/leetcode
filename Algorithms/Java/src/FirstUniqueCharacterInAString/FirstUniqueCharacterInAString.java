package src.FirstUniqueCharacterInAString;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mingqiao
 * @Date 2020/3/12
 */
public class FirstUniqueCharacterInAString {

    /**
     * 简单模拟下
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chars) {
            map.merge(ch, 1, (pre, one) -> pre + one);
        }
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (map.get(ch) == 1) {
                return i;
            }
        }
        return -1;
    }
}
