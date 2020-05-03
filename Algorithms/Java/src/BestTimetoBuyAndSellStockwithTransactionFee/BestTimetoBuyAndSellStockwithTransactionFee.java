package src.BestTimetoBuyAndSellStockwithTransactionFee;

/**
 * @author mingqiao
 * @Date 2020/2/12
 */
public class BestTimetoBuyAndSellStockwithTransactionFee {

    /**
     * 相当于卖的时候需要多付点钱，转移方程不变
     *
     * @param prices
     * @param fee
     * @return
     */
    public static int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0 || prices.length < 2) {
            return 0;
        }
        int n = prices.length;

        long dp[][] = new long[n][2];
        //初始化第一天不买or买股票的case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i][0]);
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        maxProfit(new int[] {1,3,2,8,4,9}, 2);
    }
}
