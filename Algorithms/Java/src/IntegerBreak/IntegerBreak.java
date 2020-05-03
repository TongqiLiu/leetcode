package src.IntegerBreak;

/**
 * @author mingqiao
 * @Date 2020/2/28
 */
public class IntegerBreak {

    /**
     * dp[n]为n的最优乘积，即可发现最优子问题的转移方程了
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
