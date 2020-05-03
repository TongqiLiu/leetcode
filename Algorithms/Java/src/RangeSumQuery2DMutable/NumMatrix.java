package src.RangeSumQuery2DMutable;

/**
 * @author mingqiao
 * @Date 2020/2/18
 */
class NumMatrix {

    private int[][] bit;
    private int[][] a;
    private int rows;
    private int columns;

    private int lowbit(int i) {
        return i & (-i);
    }

    private void add(int x, int y, int delta) {
        x++;
        y++;
        for (int i = x; i <= rows; i += lowbit(i)) {
            for (int j = y; j <= columns; j += lowbit(j)) {
                bit[i][j] += delta;
            }
        }
    }

    private int query(int x, int y) {
        x++;
        y++;
        int sum = 0;
        for (int i = x; i >= 1; i -= lowbit(i)) {
            for (int j = y; j >= 1; j -= lowbit(j)) {
                sum += bit[i][j];
            }
        }
        return sum;
    }

    /**
     * 二维树状数组
     *
     * @param matrix
     */
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        rows = matrix.length;
        columns = matrix[0].length;

        a = matrix;
        bit = new int[rows + 1][columns + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                add(i, j, a[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        add(row, col, val - a[row][col]);
        a[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return query(row2, col2) + query(row1 - 1, col1 - 1)
            - query(row1 - 1, col2) - query(row2, col1 - 1);
    }
}

/**
 * Your NumMmatrix object will be instantiated and called as such:
 * NumMmatrix obj = new NumMmatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */