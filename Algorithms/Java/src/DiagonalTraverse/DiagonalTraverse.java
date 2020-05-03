package src.DiagonalTraverse;

/**
 * @author mingqiao
 * @Date 2020/4/1
 */
public class DiagonalTraverse {

    /**
     * r + c 即为遍历的层数，偶数向上遍历，奇数向下遍历
     *
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[] {};
        }
        int r = 0, c = 0;
        int row = matrix.length, col = matrix[0].length;
        int[] ans = new int[row * col];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = matrix[r][c];

            if ((r + c) % 2 == 0) {
                if (c == col - 1) {
                    //到了右界，下移向下遍历
                    r++;
                } else if (r == 0) {
                    //到了上界，右移向下遍历
                    c++;
                } else {
                    r--;
                    c++;
                }
            } else {
                if (r == row - 1) {
                    //到了下界，右移向上遍历
                    c++;
                } else if (c == 0) {
                    //到了左界，下移向上遍历
                    r++;
                } else {
                    r++;
                    c--;
                }
            }
        }
        return ans;
    }
}
