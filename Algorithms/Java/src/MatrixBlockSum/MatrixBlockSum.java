package src.MatrixBlockSum;

/**
 * @author tongqi
 * @date 2025/11/16
 */
public class MatrixBlockSum {

    /**
     * 给定一个 m x n 的矩阵 mat 和一个整数 k，返回一个矩阵 answer，
     * 其中 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：
     * - i - k <= r <= i + k
     * - j - k <= c <= j + k
     * - (r, c) 在矩阵内
     * 
     * 解题思路：
     * 使用二维前缀和来快速计算矩形区域的和
     * 
     * 时间复杂度：O(m * n)，其中m和n是矩阵的行数和列数
     * 空间复杂度：O(m * n)，用于存储前缀和数组
     * 
     * @param mat 输入矩阵
     * @param k 范围参数
     * @return 结果矩阵
     */
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        // 构建二维前缀和数组
        // prefixSum[i+1][j+1] 表示从(0,0)到(i,j)的矩形区域和
        int[][] prefixSum = new int[m + 1][n + 1];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefixSum[i + 1][j + 1] = prefixSum[i][j + 1] + prefixSum[i + 1][j] 
                                         - prefixSum[i][j] + mat[i][j];
            }
        }
        
        // 计算结果矩阵
        int[][] answer = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 计算边界
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);
                
                // 使用前缀和计算矩形区域和
                // 公式：sum = prefixSum[r2+1][c2+1] - prefixSum[r1][c2+1] 
                //            - prefixSum[r2+1][c1] + prefixSum[r1][c1]
                answer[i][j] = prefixSum[r2 + 1][c2 + 1] - prefixSum[r1][c2 + 1]
                             - prefixSum[r2 + 1][c1] + prefixSum[r1][c1];
            }
        }
        
        return answer;
    }
}
