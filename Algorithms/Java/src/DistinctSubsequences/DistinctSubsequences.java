package src.DistinctSubsequences;

/**
 * author: mingqiao
 * Date: 2019/1/25
 */

//题解：动态规划解决，dp[i][j]代表t,s两串分别到i,j位置上时的匹配数目，算法复杂度O(N * M)
public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        if(s.isEmpty() || s.length() < t.length()) {
            return 0;
        }

        int ls = s.length(), lt = t.length();

        int[][] dp = new int[lt + 1][ls + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= lt; i++) {
            dp[i][0] = 0;
        }
        for(int j = 1; j <= ls; j++) {
            dp[0][j] = 1;
        }

        for(int i = 1; i <= lt; i++) {
            for(int j = 1; j <= ls; j++) {
                dp[i][j] = dp[i][j - 1];

                if(s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[lt][ls];
    }
}
