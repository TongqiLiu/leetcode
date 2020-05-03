package src.MaximumProductSubarray;

/**
 * @author mingqiao
 * @Date 2020/2/18
 */
public class MaximumProductSubarray {

    /**
     * 维护一个到当前位置的乘积最大值以及最小值，如果遇到负数则交换上一步的最大与最小值
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = Integer.MIN_VALUE, max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }

            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
