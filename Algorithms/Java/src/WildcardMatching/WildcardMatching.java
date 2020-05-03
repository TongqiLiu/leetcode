package src.WildcardMatching;

/**
 * @author mingqiao
 * @Date 2019/12/4
 */
public class WildcardMatching {

    /**
     * 注意状态转移方程的临界判断，复杂度O(M * N)
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                dp[0][i + 1] = dp[0][i];
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '*') {
                    //连续字母通配，从左或上方转移而来
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j] || dp[i][j];
                } else if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
                    //单字母通配，一定从左上角转移而来
                    dp[i + 1][j + 1] = dp[i][j];
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
