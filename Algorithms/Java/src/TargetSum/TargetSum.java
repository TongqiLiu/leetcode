package src.TargetSum;

/**
 * @author mingqiao
 * @Date 2020/3/5
 */
public class TargetSum {

    /**
     * 定义sum(P) - sum(N) = S，那么有sum(P) + sum(N) + sum(P) - sum(N) = S + sum(P) + sum(N)，
     * 即2 * sum(P) = S + sum(nums)，即寻找一个正数子集满足子集和为 (S + sum(nums))/2，0-1背包模型套入
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }

        int target = (S + sum) / 2;
        int[] dp = new int[target + 1];

        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];

            }
        }
        return dp[target];
    }
}
