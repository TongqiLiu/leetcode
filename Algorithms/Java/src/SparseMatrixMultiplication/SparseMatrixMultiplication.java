package src.SparseMatrixMultiplication;

/**
 * @author mingqiao
 * @Date 2020/3/11
 */
public class SparseMatrixMultiplication {

    /**
     * 题目地址：https://leetcode-cn.com/problems/sparse-matrix-multiplication/
     * 遍历A矩阵的行乘上B矩阵的列
     *
     * @param A
     * @param B
     * @return
     */
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];
        int i, j, k;
        for (i = 0; i < A.length; i++) {
            for (j = 0; j < B[0].length; j++) {
                C[i][j] = 0;
                for (k = 0; k < B.length; k++) {
                    C[i][j] += (A[i][k] * B[k][j]);
                }
            }
        }
        return C;
    }
}
