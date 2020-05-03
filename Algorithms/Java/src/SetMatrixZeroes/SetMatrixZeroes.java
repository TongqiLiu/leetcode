package src.SetMatrixZeroes;

import java.util.HashSet;
import java.util.Set;

import src.AlienDictionary.AlienDictionary.TopoSort;

/**
 * @author mingqiao
 * @Date 2020/1/7
 */
public class SetMatrixZeroes {

    /**
     * 题解感觉过于追求trick了...
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
