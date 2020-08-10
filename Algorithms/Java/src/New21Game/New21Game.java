package src.New21Game;

/**
 * @author mingqiao
 * @Date 2020/8/7
 */
public class New21Game {

    /**
     * 题目地址：https://leetcode-cn.com/problems/new-21-game/
     * 比较容易想到的转移方程是完全背包O(N * W)复杂度的，这个复杂度内会有[i-W, i-1]的移动区间，
     * 故当i右移时可以通过前缀和去左加右的方式滑动计算，复杂度便降到了O(N)
     *
     * @param N
     * @param K
     * @param W
     * @return
     */
    public double new21Game(int N, int K, int W) {
        if (K == 0 || N >= K + W) {
            return 1.0;
        }
        double[] dp = new double[N + 1];
        double preSum = 0;
        double ans = 0;

        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            if (i <= K) {
                preSum += dp[i - 1];
            }
            if (i - W - 1 >= 0) {
                preSum -= dp[i - W - 1];
            }
            dp[i] = preSum * (1.0 / W);
            if (i >= K) {
                ans += dp[i];
            }
        }
        return ans;
    }
}
