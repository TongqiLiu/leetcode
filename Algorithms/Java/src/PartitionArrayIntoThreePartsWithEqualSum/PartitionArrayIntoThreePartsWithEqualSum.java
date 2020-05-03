package src.PartitionArrayIntoThreePartsWithEqualSum;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/3/11
 */
public class PartitionArrayIntoThreePartsWithEqualSum {

    public boolean canThreePartsEqualSum(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }

        int sum = Arrays.stream(A).sum();
        if (sum % 3 != 0) {
            return false;
        }

        int r = 0, tmp = 0, target = sum / 3, times = 0;
        while (r < A.length) {
            tmp += A[r++];

            if (tmp == target) {
                times++;
                tmp = 0;
            }
        }
        if (sum == 0) {
            return times >= 3;
        }
        return times == 3;
    }
}
