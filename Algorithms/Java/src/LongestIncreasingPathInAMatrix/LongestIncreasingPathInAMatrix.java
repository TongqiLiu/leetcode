package src.LongestIncreasingPathInAMatrix;

/**
 * @author mingqiao
 * @Date 2020/3/23
 */
public class LongestIncreasingPathInAMatrix {

    /**
     * 地址：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
     * 记忆化搜索，dp[i][j]表示到(i,j)位置开始的最长递增路径，复杂度O(M * N)
     *
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int ans = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans = Math.max(ans, dfs(matrix, Integer.MIN_VALUE, dp, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int pre, int[][] dp, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= pre) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int res = 0;
        res = Math.max(res, dfs(matrix, matrix[i][j], dp, i - 1, j));
        res = Math.max(res, dfs(matrix, matrix[i][j], dp, i + 1, j));
        res = Math.max(res, dfs(matrix, matrix[i][j], dp, i, j - 1));
        res = Math.max(res, dfs(matrix, matrix[i][j], dp, i, j + 1));

        dp[i][j] = res + 1;
        return dp[i][j];
    }
}
