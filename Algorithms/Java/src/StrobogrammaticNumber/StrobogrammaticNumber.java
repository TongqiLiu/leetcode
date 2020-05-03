package src.StrobogrammaticNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mingqiao
 * @Date 2020/2/16
 */
public class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('0', '0');
        map.put('1', '1');
        for (int i = 0; i < (num.length() + 1) / 2; i++) {
            char left = num.charAt(i);
            char right = num.charAt(num.length() - 1 - i);
            if (map.get(left) == null || map.get(left) != right) {
                return false;
            }
        }
        return true;
    }
}
