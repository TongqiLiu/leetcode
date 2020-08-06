package src.PalindromeRemoval;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/8/6
 */
public class PalindromeRemoval {

    /**
     * 题目链接：https://leetcode-cn.com/problems/palindrome-removal/
     * dp[i][j]表示删除[i,j]区间所需要的最小次数，那么当
     * arr[i]==arr[j]时，首先肯定可以从内侧直接扩展而来，但也可以通过删除[i][k],[k+1][j]之和转移而来（比如121131这种）
     * arr[i]!=arr[j]时，只能通过枚举k区间分割转移而来，复杂度为O(N ^ 3)
     *
     * @param arr
     * @return
     */
    public int minimumMoves(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length < 2) {
            return arr.length;
        }

        //初始化
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int j = 1; j < n; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (arr[i] == arr[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                    if (i + 1 == j) {
                        dp[i][j] = 1;
                    }
                }

                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
