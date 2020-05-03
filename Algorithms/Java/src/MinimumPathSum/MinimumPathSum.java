package src.MinimumPathSum;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/1/1
 */
public class MinimumPathSum {

    /**
     * 状态转移方程比较自然
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length, m = grid[0].length;
        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j + 1 < m) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + grid[i][j + 1]);
                }
                if (i + 1 < n) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + grid[i + 1][j]);
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
