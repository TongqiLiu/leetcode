package src.CountNumbersWithUniqueDigits;

/**
 * @author mingqiao
 * @Date 2020/10/14
 */
public class CountNumbersWithUniqueDigits {

    /**
     * 题目地址：https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
     * dp[n]表示结果数，易知dp[0]=1,dp[1]=10，那么由n-1个数构成的不重复位结果为(dp[n-1] - dp[n-2])，
     * 由于用了n-1个数，故还剩的可选个数为(10 - (n - 1))填充到第n位上，复杂度O(N)
     *
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 10;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + (dp[i - 1] - dp[i - 2]) * (10 - (i - 1));
        }
        return dp[n];
    }
}


