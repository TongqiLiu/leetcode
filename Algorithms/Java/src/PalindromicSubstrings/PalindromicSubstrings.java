package src.PalindromicSubstrings;

/**
 * @author mingqiao
 * @Date 2020/1/25
 */
public class PalindromicSubstrings {

    /**
     * 中心扩展，dp[s][t]表示[s,t]区间内字符串是否为回文，注意初始化时要初始化2个字符串的情况，复杂度O(N ^ 2)
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (i + 1 < s.length() && j - 1 >= 0)
                    && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (dp[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
