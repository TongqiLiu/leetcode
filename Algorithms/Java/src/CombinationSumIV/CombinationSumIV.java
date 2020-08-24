package src.CombinationSumIV;

/**
 * @author mingqiao
 * @Date 2020/8/24
 */
public class CombinationSumIV {

    /**
     * 比之于完全背包，本题放开了全排列限制，故循环顺序和背包刚好相反
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
