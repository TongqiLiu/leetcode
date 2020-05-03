package src.BestTimeToBuyAndSellStockIII;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/2/6
 */
public class BestTimeToBuyAndSellStockIII {

    /**
     * dp[n][k][2]表示第n天最多完成k次卖出后手中无股票/有股票所能获取的最大利益
     * 注意数值溢出及卖了赔钱的bad case
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        long dp[][][] = new long[n][3][2];
        //初始化第一天不买or买股票的case，且第一天不可能有卖出
        dp[0][0][0] = 0;
        dp[0][1][0] = 0;
        dp[0][2][0] = 0;
        dp[0][0][1] = -prices[0];
        dp[0][1][1] = -prices[0];
        dp[0][2][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
            for (int j = 1; j <= 2; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return (int)Math.max(0, Math.max(dp[n - 1][1][0], dp[n - 1][2][0]));
    }

    public static void main(String[] args) {
        maxProfit(new int[] {3, 3, 5, 0, 0, 3, 1, 4});
    }
}
