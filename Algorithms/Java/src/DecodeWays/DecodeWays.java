package src.DecodeWays;

/**
 * @author mingqiao
 * @Date 2020/2/17
 */
public class DecodeWays {

    /**
     * 因为字符串可以由加一个字符or两个字符转移而来，故dp[n] = dp[n - 1] + dp[n - 2]
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            //判断最后两位组成字母合法的情况
            if ((s.charAt(i - 2) == '1') ||
                (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];

    }
}
