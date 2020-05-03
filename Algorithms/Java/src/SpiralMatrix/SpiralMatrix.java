package src.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2019/12/26
 */
public class SpiralMatrix {

    /**
     * 题解：模拟一下右、下、左、上四条轨迹线，边界不断收缩直至发生交汇
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        int n = matrix.length, m = matrix[0].length;
        int up = 0, down = n - 1, left = 0, right = m - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            if (++up > down) {
                break;
            }
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            if (--down < up) {
                break;
            }
            for (int i = down; i >= up; i--) {
                list.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
