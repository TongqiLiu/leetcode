package src.UniquePathsII;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/1/1
 */
public class UniquePathsII {

    /**
     * 记忆化搜索写法，注意两个角边界问题
     *
     * @param m
     * @param n
     * @param x
     * @param y
     * @param count
     * @return
     */
    private static int dfs(int m, int n, int x, int y, int[] count, int[][] obstacleGrid) {
        if (x >= n || y >= m) {
            return 0;
        }
        if (x == n - 1 && y == m - 1) {
            return count[x * m + y] = obstacleGrid[x][y] == 0 ? 1 : 0;
        }

        if (count[x * m + y] == -1) {
            int countRight = (x + 1 < n && obstacleGrid[x + 1][y] == 0) ?
                dfs(m, n, x + 1, y, count, obstacleGrid) : 0;
            int countDown = (y + 1 < m && obstacleGrid[x][y + 1] == 0) ?
                dfs(m, n, x, y + 1, count, obstacleGrid) : 0;
            count[x * m + y] = countRight + countDown;
        }
        return count[x * m + y] = obstacleGrid[x][y] == 0 ? count[x * m + y] : 0;
    }

    /**
     * dp，注意边界判断条件
     *
     * @param m
     * @param n
     * @return
     */
    public static int dp(int m, int n, int[][] obstacleGrid) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 0);
        }
        int rightFlag = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (obstacleGrid[i][m - 1] == 1 || rightFlag == 1) {
                rightFlag = 1;
                dp[i][m - 1] = 0;
            } else {
                dp[i][m - 1] = 1;
            }
        }

        int downFlag = 0;
        for (int i = m - 1; i >= 0; i--) {
            if (obstacleGrid[n - 1][i] == 1 || downFlag == 1) {
                downFlag = 1;
                dp[n - 1][i] = 0;
            } else {
                dp[n - 1][i] = 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i + 1][j] + dp[i][j + 1] : 0;
            }
        }
        return dp[0][0];
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        if (m <= 0 || n <= 0) {
            return 0;
        }

        //int[] count = new int[m * n];
        //Arrays.fill(count, -1);
        //dfs(m, n, 0, 0, count, obstacleGrid);
        //return count[0];

        return dp(m, n, obstacleGrid);
    }

    public static void main(String[] args) {
        int[][] a = {{0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(a));
    }
}
