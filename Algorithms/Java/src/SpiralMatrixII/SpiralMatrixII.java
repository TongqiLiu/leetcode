package src.SpiralMatrixII;

/**
 * @author mingqiao
 * @Date 2019/12/30
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return null;
        }

        int[][] ans = new int[n][n];
        int up = 0, down = n - 1, left = 0, right = n - 1, number = 1;

        while (true) {
            for (int i = left; i <= right; i++) {
                ans[up][i] = number++;
            }
            if (++up > down) {
                break;
            }
            for (int i = up; i <= down; i++) {
                ans[i][right] = number++;
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                ans[down][i] = number++;
            }
            if (--down < up) {
                break;
            }
            for (int i = down; i >= up; i--) {
                ans[i][left] = number++;
            }
            if (++left > right) {
                break;
            }
        }
        return ans;
    }
}
