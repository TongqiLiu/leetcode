package src.InterleavingString;

/**
 * @author mingqiao
 * @Date 2020/10/14
 */
public class InterleavingString {

    /**
     * 题解：https://leetcode-cn.com/problems/interleaving-string/
     * dp[i][j]表示s1[0,i-1]和s2[0,j-1]能否交错组成s3[0,i+j-1]，注意边界处理
     * 时空复杂度均为O(N * M)
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length();
        if (s3.length() != n + m) {
            return false;
        }
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (s3.charAt(i - 1) == s1.charAt(i - 1)) {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i <= m; ++i) {
            if (s3.charAt(i - 1) == s2.charAt(i - 1)) {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    //如果s1的第i个元素和s3的第i+j个元素相同，那么dp[i][j]取决于
                    // 前s1的i-1个元素能否和s2的j个元素组成s3的i+j-1个元素
                    dp[i][j] |= dp[i - 1][j];
                }
                if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    //同上
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }
}
