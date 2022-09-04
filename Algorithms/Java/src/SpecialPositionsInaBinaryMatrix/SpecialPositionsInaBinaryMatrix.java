package src.SpecialPositionsInaBinaryMatrix;

/**
 * @author mingqiao
 * @Date 2022/9/4
 */
public class SpecialPositionsInaBinaryMatrix {

    /**
     * 简单模拟题
     *
     * @param mat
     * @return
     */
    public int numSpecial(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0] == null || mat[0].length == 0) {
            return 0;
        }
        int n = mat.length, m = mat[0].length;
        int[] rowSum = new int[n], colSum = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
            }
        }

        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1) {
                    num += 1;
                }
            }
        }
        return num;
    }
}
