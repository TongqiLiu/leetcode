package src.ZigZagConversion;

import sun.security.util.Length;

import java.util.Arrays;

/**
 * Created by tongqi on 2017/4/20.
 * Email: tongqicode@126.com
 */

//解题思路：模拟即可，flag用来判断当前状态是向下还是斜向上

public class ZigZagConversion {

    public String convert(String s, int numRows) {
        int n = s.length(), row = 0, flag = 0;
        if (n == 0 || n == 1 || numRows == 1) return s;

        String ans = "";
        String[] strings = new String[n];
        Arrays.fill(strings, "");
        for (int i = 0; i < n; i++) {
            strings[row] += s.charAt(i);

            if (flag == 0) {
                if (row == numRows - 1) {
                    flag = 1;
                    row--;
                } else row++;
            } else {
                if (row == 0) {
                    flag = 0;
                    row++;
                } else row--;
            }
        }

        for (int i = 0; i < n; i++) ans += strings[i];
        return ans;
    }
}
