package src.PartitionToKEqualSumSubsets;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/3/15
 */
public class PartitionToKEqualSumSubsets {

    boolean dfs(int[] nums, int cur, int[] val, int k) {
        //已经遍历到了-1说明前面的所有数都正好可以放入桶里
        if (cur < 0) {
            int sum = Arrays.stream(val).sum();
            return sum == 0;
        }
        for (int i = 0; i < k; i++) {
            //剪枝
            if (val[i] >= nums[cur] && val[i] - nums[cur] >= nums[0]) {
                val[i] -= nums[cur];

                //开始放下一个数
                if (dfs(nums, cur - 1, val, k)) {
                    return true;
                }

                val[i] += nums[cur];
            }
        }
        return false;
    }

    /**
     * 暴力搜索，注意倒序来排将大的数优先放进去
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }

        //数组从小到大排序，如果子集的和小于数组最大的直接返回false
        sum = sum / k;
        Arrays.sort(nums);
        if (nums[nums.length - 1] > sum) {
            return false;
        }

        //分为k个桶
        int[] val = new int[k];
        Arrays.fill(val, sum);
        //从数组最后一个数开始进行递归，优先放大的数
        return dfs(nums, nums.length - 1, val, k);
    }
}
