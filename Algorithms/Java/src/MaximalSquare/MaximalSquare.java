package src.MaximalSquare;

/**
 * @author mingqiao
 * @Date 2020/2/16
 */
public class MaximalSquare {

    /**
     * dp[i][j]表示到(i,j)位置能组成的最大正方形长度，易知该节点会从左上，上，左三个方向转移而来
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r][c];
        int maxLen = 0;
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] == '1') {
                maxLen = 1;
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < c; i++) {
            if (matrix[0][i] == '1') {
                maxLen = 1;
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }
}
