package src.BestTimeToBuyAndSellStockIV;

/**
 * @author mingqiao
 * @Date 2020/2/9
 */
public class BestTimeToBuyAndSellStockIV {

    /**
     * 转移方程和上题类似，不过k过大时会超内存，有个trick是当k>n/2时相当于无限制了即可转化为2问题
     *
     * @param k
     * @param prices
     * @return
     */
    public static int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        if (k > n / 2) {
            return maxProfitNoLimit(prices);
        }

        long dp[][][] = new long[n][k + 1][2];
        //初始化第一天不买or买股票的case，且第一天不可能有卖出
        for (int i = 0; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        long ans = 0;
        for (int i = 0; i <= k; i++) {
            ans = Math.max(dp[n - 1][i][0], ans);
        }
        return (int)ans;
    }

    public static int maxProfitNoLimit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[] diff = new int[prices.length - 1];
        for (int i = 0; i < prices.length - 1; i++) {
            diff[i] = prices[i + 1] - prices[i];
        }

        int ans = 0;
        for (int i = 0; i < diff.length; i++) {
            if (diff[i] > 0) {
                ans += diff[i];
            }
        }
        return ans < 0 ? 0 : ans;
    }

    public static void main(String[] args) {
        maxProfit(2, new int[] {3, 2, 6, 5, 0, 3});
    }

}
