package src.MaximumSubarray;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2019/12/26
 */
public class MaximumSubarray {

    /**
     * 简单的状态转移方程，每个节点选或不选之前的子数组和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int ans;
        ans = dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}
