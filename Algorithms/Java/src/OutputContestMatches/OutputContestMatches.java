package src.OutputContestMatches;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/2/25
 */
public class OutputContestMatches {

    /**
     * 模拟一下，不断将后面的子对前提，复杂度O(N * logN)，如：
     * [1, 2, 3, 4, 5, 6, 7, 8]
     * [(1,8), (2,7), (3,6), (4,5), 5, 6, 7, 8]
     * [((1,8),(4,5)), ((2,7),(3,6)), (3,6), (4,5), 5, 6, 7, 8]
     * [(((1,8),(4,5)),((2,7),(3,6))), ((2,7),(3,6)), (3,6), (4,5), 5, 6, 7, 8]
     *
     * @param n
     * @return
     */
    public String findContestMatch(int n) {
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = String.valueOf(i + 1);
        }

        while (n >= 2) {
            for (int i = 0; i < n / 2; i++) {
                s[i] = "(" + s[i] + "," + s[n - 1 - i] + ")";
            }
            //System.out.println(Arrays.toString(s));
            n /= 2;
        }
        return s[0];
    }
}
