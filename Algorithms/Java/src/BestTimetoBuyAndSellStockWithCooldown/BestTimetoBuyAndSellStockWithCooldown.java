package src.BestTimetoBuyAndSellStockWithCooldown;

/**
 * @author mingqiao
 * @Date 2020/2/12
 */
public class BestTimetoBuyAndSellStockWithCooldown {

    /**
     * 转移方程很接近，注意边界问题
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length < 2) {
            return 0;
        }

        int n = prices.length;

        long dp[][] = new long[n][2];
        //初始化第一天不买or买股票的case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(0, prices[1] - prices[0]);
        dp[1][1] = Math.max(-prices[0], -prices[1]);

        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return (int)Math.max(0, dp[n - 1][0]);
    }
}
