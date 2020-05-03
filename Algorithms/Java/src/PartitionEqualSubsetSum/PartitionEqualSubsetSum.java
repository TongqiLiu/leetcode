package src.PartitionEqualSubsetSum;

/**
 * @author mingqiao
 * @Date 2020/3/15
 */
public class PartitionEqualSubsetSum {

    /**
     * 地址：
     * 0-1背包解法，每个数有选与不选两种可能，滚动数组优化空间，时间复杂度O(N * SUM / 2)
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //总和为奇数可以直接判掉
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                //不选or选两种场景
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
