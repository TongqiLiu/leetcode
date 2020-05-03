package src.MinimumFallingPathSum;

/**
 * @author mingqiao
 * @Date 2020/3/23
 */
public class MinimumFallingPathSum {

    /**
     * 类似杨辉三角的状态转移方程，注意边界的初始化，复杂度O(N * N)
     *
     * @param A
     * @return
     */
    public int minFallingPathSum(int[][] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[][] dp = new int[n + 2][n + 2];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][n + 1] = Integer.MAX_VALUE;

            dp[n + 1][i] = Integer.MAX_VALUE;
            dp[0][i] = 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]) + A[i - 1][j - 1];
                if (i == n) {
                    ans = Math.min(ans, dp[n][j]);
                }
            }
        }
        return ans;
    }
}
