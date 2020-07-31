package src.GetMaxMatrix;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/7/31
 */
public class GetMaxMatrix {

    /**
     * 题目链接：https://leetcode-cn.com/problems/max-submatrix-lcci/
     * 首先回忆下一维数组求解最大子数组和的方法，然后枚举(i, j)作为行区间上下限，将其进行压缩并累计k列的
     * sum(i, j)记为rowSum[k]，这样就转化成了一位数组rowSum求解最大子数组和的问题
     * 复杂度O(N ^ 2 * M)
     *
     * @param matrix
     * @return
     */
    public int[] getMaxMatrix(int[][] matrix) {
        int[] ans = new int[4];
        int n = matrix.length;
        int m = matrix[0].length;

        int max = Integer.MIN_VALUE, r1 = 0, c1 = 0;
        int[] rowSum = new int[m];

        for (int i = 0; i < n; i++) {

            Arrays.fill(rowSum, 0);
            for (int j = i; j < n; j++) {
                int sum = 0;

                for (int k = 0; k < m; k++) {
                    rowSum[k] += matrix[j][k];

                    if (sum > 0) {
                        sum += rowSum[k];
                    } else {
                        //证明可以抛弃原本的起始位置，起始点挪到当前位置
                        sum = rowSum[k];
                        r1 = i;
                        c1 = k;
                    }

                    if (sum > max) {
                        max = Math.max(max, sum);
                        ans[0] = r1;
                        ans[1] = c1;
                        ans[2] = j;
                        ans[3] = k;
                    }
                }
            }
        }
        return ans;
    }
}
