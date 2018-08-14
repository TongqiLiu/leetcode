package src.LongestPalindromicSubstring;

/**
 * Created by tongqi on 2017/4/20.
 * Email: tongqicode@126.com
 */

//题解：dp[i][j]表示s[i, j]这个子串是否回文，转移即可，复杂度O(N ^ 2).
//     也可以从双指针中间向两边扩展，后缀数组，KMP马拉车算法也都可以解决这个问题

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return s;

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        String string = "";
        int maxlen = 0;
        for (int i = n - 1; i >= 0; i--)
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (maxlen < j - i + 1) {
                        maxlen = j - i + 1;
                        string = s.substring(i, j + 1);
                    }
                }
            }
        return string;
    }
}