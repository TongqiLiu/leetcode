package src.EditDistance;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2019/12/22
 */
public class EditDistance {

    /**
     * dp[i][j]表示两串i,j两位置的最小编辑距离，那么它可以从三种状态转移而来
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int flag = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
                dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + flag);
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
