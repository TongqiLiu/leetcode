package src.RegularExpressionMatching;

/**
 * Created by tongqi on 2017/4/23.
 * Email: tongqicode@126.com
 */

//解题思路：dp[i + 1][j + 1]代表s[0, i]和p[0, j]是否满足完全匹配
//         注意"x*"可以代表x出现了0次，1次，>=2次，所以转移方程需要考虑三种情况(可以举例如：s = "aaa", p = "a*")

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {

        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for (int i = 0; i < m; i++)
            dp[i + 1][0] = false;
        for (int i = 0; i < n; i++)
            dp[0][i + 1] = i > 0 && p.charAt(i) == '*' && dp[0][i - 1];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (p.charAt(j) != '*') {
                    dp[i + 1][j + 1] = dp[i][j] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j] || (j > 0 && dp[i + 1][j - 1])
                            || (j > 0 && dp[i][j + 1] && (p.charAt(j - 1) == '.' || s.charAt(i) == p.charAt(j - 1)));
                }
            }

        return dp[m][n];
    }
}
