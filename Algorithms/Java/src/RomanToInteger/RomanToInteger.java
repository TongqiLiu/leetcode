package src.RomanToInteger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tongqi on 2018/8/14.
 * Email: tongqicode@126.com
 */

//题解：和邻居题类似，模拟下

public class RomanToInteger {

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>() {
            {
                put("M", 1000);
                put("CM", 900);
                put("D", 500);
                put("CD", 400);
                put("C", 100);
                put("XC", 90);
                put("L", 50);
                put("XL", 40);
                put("X", 10);
                put("IX", 9);
                put("V", 5);
                put("IV", 4);
                put("I", 1);
            }
        };

        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            String key = String.valueOf(s.charAt(i));
            if(i + 1 < s.length()) {
                String newKey = key + s.charAt(i + 1);
                if(map.containsKey(newKey)) {
                    ans += map.get(newKey);
                    i++;
                    continue;
                }
            }
            ans += map.get(key);
        }
        return ans;
    }

    //public static void main(String[] args) {
    //    RomanToInteger romanToInteger = new RomanToInteger();
    //    System.out.println(romanToInteger.romanToInt("II"));
    //}
}