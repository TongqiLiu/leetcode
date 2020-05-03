package src.HouseRobber;

/**
 * @author mingqiao
 * @Date 2020/2/9
 */
public class HouseRobber {

    /**
     * dp[n]表示第n天能获得的最大值，易得出状态转移方程
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[n];
    }
}
