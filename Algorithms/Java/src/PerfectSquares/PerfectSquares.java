package src.PerfectSquares;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/2/16
 */
public class PerfectSquares {

    /**
     * 先写出记忆化搜索，再写状态转移方程
     *
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        int sqrt = (int)Math.sqrt(n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);

        dp[0] = 0;
        for (int i = 1; i <= sqrt; i++) {
            dp[i * i] = 1;
            dp[i] = Math.min(dp[i], i);
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        numSquares(12);
    }
}
