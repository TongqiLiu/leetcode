package src.PaintFence;

/**
 * @author mingqiao
 * @Date 2020/2/25
 */
public class PaintFence {

    /**
     * dp[n][2]分别表示第n个栅栏跟上一个是否一样
     *
     * @param n
     * @param k
     * @return
     */
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }

        int[][] dp = new int[n][2];
        dp[0][0] = k;
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] * (k - 1) + dp[i - 1][1] * (k - 1);
            dp[i][1] = dp[i - 1][0];
        }
        return dp[n - 1][0] + dp[n - 1][1];
    }
}
