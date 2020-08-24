package src.MaximumSizeSubarraySumEqualsk;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mingqiao
 * @Date 2020/8/24
 */
public class MaximumSizeSubarraySumEqualsk {

    /**
     * 题目地址：https://leetcode-cn.com/problems/maximum-size-subarray-sum-equals-k/
     * 容易想出前缀和O(N ^ 2)的算法，然后通过map存储区间最长的前缀和位置，复杂度可降到O(N)
     *
     * @param nums
     * @param k
     * @return
     */
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int sum = 0, ans = 0;
        for (int i = 0; i < len; i++) {
            sum = sum + nums[i];
            if (sum == k) {
                ans = i + 1;
            }

            //前缀和思路
            if (map.containsKey(sum - k)) {
                ans = Math.max(ans, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return ans;
    }
}
