package src.ReverseString;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/2/10
 */
public class ReverseString {

    /**
     * 模拟即可
     *
     * @param s
     */
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int l = 0, r = s.length - 1;
        while (l <= r) {
            char tmp = s[r];
            s[r] = s[l];
            s[l] = tmp;

            l++;
            r--;
        }

    }
}
