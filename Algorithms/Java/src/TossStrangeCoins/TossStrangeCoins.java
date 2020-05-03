package src.TossStrangeCoins;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/3/1
 */
public class TossStrangeCoins {

    /**
     * dp[i][j]抛了前i枚硬币, 有j枚朝上的概率
     *
     * @param prob
     * @param target
     * @return
     */
    public double probabilityOfHeads(double[] prob, int target) {
        if (prob == null || prob.length == 0) {
            return 0;
        }
        int n = prob.length;
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            //i次全部朝下的可能性
            dp[i][0] = dp[i - 1][0] * (1 - prob[i - 1]);
            for (int j = 1; j <= i; j++) {
                //前者代表上次抛出j次朝上且本次朝下，后者代表上次抛出j-1次且本次朝上
                dp[i][j] = dp[i - 1][j] * (1 - prob[i - 1]) + dp[i - 1][j - 1] * prob[i - 1];
            }
        }
        return dp[n][target];
    }

    /**
     * 背包问题的思路，滚动数组优化空间
     *
     * @param prob
     * @param target
     * @return
     */
    public double probabilityOfHeads1(double[] prob, int target) {
        if (prob == null || prob.length == 0) {
            return 0;
        }
        int n = prob.length;
        double[] dp = new double[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            //i次全部朝下的可能性
            for (int j = i; j >= 1; j--) {
                //前者代表上次抛出j次朝上且本次朝下，后者代表上次抛出j-1次且本次朝上
                dp[j] = dp[j] * (1 - prob[i - 1]) + dp[j - 1] * prob[i - 1];
            }
            dp[0] = dp[0] * (1 - prob[i - 1]);
        }
        return dp[target];
    }
}
