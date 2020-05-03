package src.MinimumSizeSubarraySum;

/**
 * @author mingqiao
 * @Date 2020/3/3
 */
public class MinimumSizeSubarraySum {

    /**
     * 双指针滑动窗口维护窗口值的和，超过S时就从左边踢掉节点
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, ans = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            if (sum >= s) {
                ans = Math.min(ans, r - l + 1);

                while (sum >= s) {
                    ans = Math.min(ans, r - l + 1);
                    sum -= nums[l++];
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
    }
}
