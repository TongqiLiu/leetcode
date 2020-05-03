package src.UniquePaths;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/1/1
 */
public class UniquePaths {

    /**
     * 记忆化搜索写法
     *
     * @param m
     * @param n
     * @param x
     * @param y
     * @param count
     * @return
     */
    private static int dfs(int m, int n, int x, int y, int[] count) {
        if (x >= n || y >= m) {
            return 0;
        }
        if (x == n - 1 && y == m - 1) {
            return 1;
        }

        if (count[x * m + y] == 0) {
            int countRight = dfs(m, n, x + 1, y, count);
            int countDown = dfs(m, n, x, y + 1, count);
            count[x * m + y] = countRight + countDown;
        }
        return count[x * m + y];
    }

    public static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        int[] count = new int[m * n];
        Arrays.fill(count, 0);
        dfs(m, n, 0, 0, count);
        return count[0];
    }

    /**
     * dp，状态转移方程简单易得
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths1(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 0);
        }
        for (int i = n - 1; i >= 0; i--) {
            dp[i][m - 1] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            dp[n - 1][i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(10, 10));
        System.out.println(uniquePaths1(10, 10));
    }
}
