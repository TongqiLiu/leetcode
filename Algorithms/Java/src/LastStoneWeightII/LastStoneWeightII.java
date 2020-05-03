package src.LastStoneWeightII;

/**
 * @author mingqiao
 * @Date 2020/3/25
 */
public class LastStoneWeightII {

    /**
     * 地址：https://leetcode-cn.com/problems/last-stone-weight-ii/
     * 转化下就是两个子集和的最小差值，即转为一个01背包问题，背包容积为重量和/2，尽可能将石头装进背包
     *
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int sub = sum >> 1;
        int[] dp = new int[sub + 1];

        for (int i = 0; i < stones.length; i++) {
            for (int j = sub; j >= stones[i]; j--) {
                //石头的价值和重量是同一个东西
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[sub] * 2;
    }
}
