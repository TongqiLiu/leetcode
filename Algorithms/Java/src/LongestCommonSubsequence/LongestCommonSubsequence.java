package src.LongestCommonSubsequence;

/**
 * @author mingqiao
 * @Date 2020/3/13
 */
public class LongestCommonSubsequence {

    /**
     * 最长公共子序列经典问题，核心转移方程在于以两位置字符是否相同来分类讨论
     *
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }

        char[] s = text1.toCharArray();
        char[] t = text2.toCharArray();
        int n = s.length;
        int m = t.length;

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = (s[i] == t[0]) ? 1 : (i == 0) ? 0 : dp[i - 1][0];
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = (s[0] == t[i]) ? 1 : (i == 0) ? 0 : dp[0][i - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (s[i] == t[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        longestCommonSubsequence("abcde", "ace");
    }
}
