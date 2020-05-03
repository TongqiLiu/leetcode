package src.PaintHouse;

/**
 * @author mingqiao
 * @Date 2020/2/25
 */
public class PaintHouse {

    /**
     * 简单的dp推导
     *
     * @param costs
     * @return
     */
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int n = costs.length;
        int m = costs[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = costs[0][i];
        }
        if (n == 1) {
            return Math.min(Math.min(dp[0][0], dp[0][1]), dp[0][2]);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
            if (i == n - 1) {
                ans = Math.min(Math.min(dp[i][0], dp[i][1]), dp[i][2]);
            }
        }
        return ans;
    }
}
