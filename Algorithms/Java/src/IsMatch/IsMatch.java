package src.IsMatch;

/**
 * @author mingqiao
 * @Date 2020/3/26
 */
public class IsMatch {

    /**
     * 地址：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
     * dp[i][j]表示s前i位能否和p前j位匹配，复杂度O(N * M)
     * 注意P串字符是"*"的情况，它代表p[j - 2]=c可以重复0次或多次，故需要分类讨论：
     * 1.重复0次相当于B最后两个字符废弃，故转变成了求dp[i][j - 2]的问题
     * 2.重复多次相当于看A串i前一位能否和B的j位置匹配，且A串当前位置是否和B串前一位置相等
     * 例子：
     * S：ABCCC
     * P：ABC*
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        
        dp[0][0] = true;
        for (int j = 2; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                } else {
                    //j-2字符重复0次 or 多次的情况
                    dp[i][j] = dp[i][j - 2] ||
                        (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                }
            }
        }
        return dp[n][m];
    }
}
