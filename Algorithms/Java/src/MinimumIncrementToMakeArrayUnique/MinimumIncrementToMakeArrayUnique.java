package src.MinimumIncrementToMakeArrayUnique;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/3/22
 */
public class MinimumIncrementToMakeArrayUnique {

    /**
     * 排序完模拟一下，复杂度O(N * logN)
     * 当然也可以空间换时间，计数排序，复杂度O(N)
     *
     * @param A
     * @return
     */
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int res = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                int pre = A[i];
                A[i] = A[i - 1] + 1;
                res += A[i] - pre;
            }
        }
        return res;
    }
}
