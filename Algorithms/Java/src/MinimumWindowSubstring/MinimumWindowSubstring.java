package src.MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author mingqiao
 * @Date 2019/12/30
 */
public class MinimumWindowSubstring {

    /**
     * 两个指针去维护滑动窗口，r代表扩展加入字符l代表减少字符，countMap记录t里字符滑动窗口内需要匹配的次数
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int count = t.length();
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            countMap.merge(t.charAt(i), 1, (pre, one) -> pre + one);
        }

        int l = 0, r = 0, minHead = -1, minLen = s.length();
        while (r < s.length()) {
            char cr = s.charAt(r);
            if (countMap.containsKey(cr)) {
                Integer crNumber = countMap.get(cr);
                if (crNumber > 0) {
                    count--;
                }
                countMap.put(cr, crNumber - 1);
            }

            while (count == 0) {
                if (minLen >= r - l + 1) {
                    minLen = r - l + 1;
                    minHead = l;
                }

                char cl = s.charAt(l);
                if (countMap.containsKey(cl)) {
                    Integer clNumber = countMap.get(cl);
                    if (clNumber == 0) {
                        count++;
                    }
                    countMap.put(cl, clNumber + 1);
                }
                l++;
            }
            r++;
        }
        //System.out.println("minHead:" + minHead + ", minLen:" + minLen);
        return minHead >= 0 ? s.substring(minHead, minHead + minLen) : "";
    }

    public static void main(String[] args) {
        minWindow("ADOBECODEBANC", "ABC");
    }
}
