package src.SearchA2DMatrixII;

/**
 * @author mingqiao
 * @Date 2020/2/17
 */
public class SearchA2DMatrixII {

    /**
     * 从右上角触发，如果当前元素大于target，往左走；小于target，往下走，复杂度O(M + N)
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }
}
