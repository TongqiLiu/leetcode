package src.RangeSumQuery2DImmutable;

/**
 * @author mingqiao
 * @Date 2020/3/10
 */
public class NumMatrix {

    private int[][] sum;

    /**
     * 维护二维数组从(0,0)到节点的和，然后容斥下
     *
     * @param matrix
     */
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) { return; }
        sum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                sum[r + 1][c + 1] = sum[r + 1][c] + sum[r][c + 1] + matrix[r][c] - sum[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
    }
}
