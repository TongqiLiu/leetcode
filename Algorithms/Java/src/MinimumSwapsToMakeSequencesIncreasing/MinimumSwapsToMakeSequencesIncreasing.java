package src.MinimumSwapsToMakeSequencesIncreasing;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/2/9
 */
public class MinimumSwapsToMakeSequencesIncreasing {

    /**
     * dp[i][2]表示到到i位置维护单调递增且i位置不交换/进行交换的最小交换次数
     *
     * @param A
     * @param B
     * @return
     */
    public int minSwap(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return 0;
        }
        int n = A.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                //i位置不交换 or i位置交换时则i-1位置也需要交换
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] + 1;
            }
            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                //i位置交换的话i-1位置之前不可动 or 上一位置已交换好
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
            }
        }

        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}
