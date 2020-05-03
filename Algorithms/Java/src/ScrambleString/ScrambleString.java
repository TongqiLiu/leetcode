package src.ScrambleString;

import java.util.HashMap;

/**
 * @author mingqiao
 * @Date 2020/1/5
 */
public class ScrambleString {

    private static HashMap<String, Integer> vis = new HashMap<>();

    public static int getStringVisited(String s1, String s2) {
        return vis.getOrDefault(s1 + "#" + s2, -1);
    }

    public static void putStringVisited(String s1, String s2, int value) {
        vis.put(s1 + "#" + s2, value);
    }

    /**
     * 枚举每一个节点进行分割，然后判定分割后的s1子树和s2子树是否"相等"，这里"相等"有两种情况：
     * 1.分割后，s1左部和s2左部可匹配，右部可匹配
     * 2.分割后，s1左部和右部交换，然后重复1
     * 可以通过标记数组完成记忆化搜索，时间复杂度看循环可知：f(n) = f(1) + f(n-1) + ... + f(n-1) + f(1) = 2 * (f(1) + f(2) + ... f(n-1)) = 3 * f(n-1)
     * 故时间复杂度为O(3 ^ n)
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean dfs(String s1, String s2) {
        int visited = getStringVisited(s1, s2);
        if (visited == 1) {
            return true;
        }
        if (visited == 0) {
            return false;
        }

        if (s1.length() != s2.length()) {
            putStringVisited(s1, s2, 0);
            return false;
        }
        if (s1.equals(s2)) {
            putStringVisited(s1, s2, 1);
            return true;
        }

        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                putStringVisited(s1, s2, 0);
                return false;
            }
        }

        for (int i = 1; i < s1.length(); i++) {
            //case 1：
            if (dfs(s1.substring(0, i), s2.substring(0, i))
                && dfs(s1.substring(i), s2.substring(i))) {
                putStringVisited(s1, s2, 1);
                return true;
            }
            //case 2：swap left right
            if (dfs(s1.substring(i), s2.substring(0, s2.length() - i))
                && dfs(s1.substring(0, i), s2.substring(s2.length() - i))) {
                putStringVisited(s1, s2, 1);
                return true;
            }
        }

        putStringVisited(s1, s2, 0);
        return false;
    }

    /**
     * dp[len][s1][s2]表示，s1[i,i+len)及s2[j,j+len]是否满足匹配条件，复杂度O(N ^ 4)
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean dp(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        int n = s1.length();
        boolean[][][] dp = new boolean[n + 1][n + 1][n + 1];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                for (int j = 0; j + len <= n; j++) {
                    if (len == 1) {
                        dp[len][i][j] = s1.charAt(i) == s2.charAt(j);
                    } else {
                        for (int k = 1; k <= len; k++) {
                            dp[len][i][j] = (dp[k][i][j] && dp[len - k][i + k][j + k])
                                || (dp[k][i][j + len - k] && dp[len - k][i + k][j]);
                            if (dp[len][i][j]) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[n][0][0];
    }

    public static boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        vis.clear();
        //return dfs(s1, s2);
        return dp(s1, s2);
    }

    public static void main(String[] args) {
        System.out.println(isScramble("great", "rgaet"));
    }
}
