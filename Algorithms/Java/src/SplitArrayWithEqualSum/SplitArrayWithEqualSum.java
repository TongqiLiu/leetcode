package src.SplitArrayWithEqualSum;

import java.util.HashSet;

/**
 * @author mingqiao
 * @Date 2020/9/10
 */
public class SplitArrayWithEqualSum {

    /**
     * 容易想出三层循环的暴力枚举[i,j,k]组合但是会超时，这里使用优化
     * 以j位置为中心分别枚举i,k并用set记录每段和，复杂度O(N ^ 2)
     *
     * @param nums
     * @return
     */
    public boolean splitArray(int[] nums) {
        if (nums == null || nums.length < 7) {
            return false;
        }
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        //对于每个j位置，枚举前面的i位置使得两者前缀和相等，再枚举后面的k位置
        for (int j = 3; j < n - 3; j++) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                if (sum[i - 1] == sum[j - 1] - sum[i]) {
                    set.add(sum[i - 1]);
                }
            }
            for (int k = j + 2; k < n - 1; k++) {
                if (sum[n - 1] - sum[k] == sum[k - 1] - sum[j]
                    && set.contains(sum[k - 1] - sum[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
