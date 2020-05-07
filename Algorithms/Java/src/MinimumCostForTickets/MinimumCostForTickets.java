package src.MinimumCostForTickets;

public class MinimumCostForTickets {

    /**
     * 题目地址：https://leetcode-cn.com/problems/minimum-cost-for-tickets/
     * dp，当天可以从昨天，7天，30天前转移而来，复杂度O(N)
     *
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0 || costs == null || costs.length == 0) {
            return 0;
        }

        int n = days.length;
        int[] dp = new int[days[n - 1] + 1];

        dp[0] = 0;
        for (int day : days) {
            dp[day] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < dp.length; i++) {
            //不需要旅行的话就是前一天的花费
            if (dp[i] == 0) {
                dp[i] = dp[i - 1];
                continue;
            }

            int n1 = dp[i - 1] + costs[0];
            int n2 = i > 7 ? dp[i - 7] + costs[1] : costs[1];
            int n3 = i > 30 ? dp[i - 30] + costs[2] : costs[2];

            dp[i] = Math.min(n1, Math.min(n2, n3));
        }
        return dp[days[n - 1]];
    }
}
