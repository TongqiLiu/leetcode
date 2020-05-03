package src.Searcha2DMatrix;

/**
 * @author mingqiao
 * @Date 2020/1/7
 */
public class Searcha2DMatrix {

    /**
     * 二分，复杂度o(log (m * n))
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row = matrix.length, column = matrix[0].length;
        int l = 0, r = row * column - 1;
        while (l <= r) {
            int mid = l + (r - l + 1) / 2;

            if (matrix[mid / column][mid % column] == target) {
                return true;
            } else if (matrix[mid / column][mid % column] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
