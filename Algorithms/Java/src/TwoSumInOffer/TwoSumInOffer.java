package src.TwoSumInOffer;

/**
 * @author mingqiao
 * @Date 2020/3/30
 */
public class TwoSumInOffer {

    /**
     * 地址：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
     * 最后状态为n个骰子各个点数出现的概率，故定义dp[n][i]为前n个骰子和达到i的总次数
     *
     * @param n
     * @return
     */
    public double[] twoSum(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int j = 1; j <= 6; j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k <= 0) {
                        break;
                    }

                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        double total = Math.pow(6, n);
        double[] ans = new double[5 * n + 1];
        for (int i = n; i <= 6 * n; i++) {
            ans[i - n] = dp[n][i] / total;
        }
        return ans;
    }
}
