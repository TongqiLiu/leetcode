package src.BurstBalloons;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/2/15
 */
public class BurstBalloons {

    /**
     * dp[l][r]表示戳破[l,r]间的气球所能获得的最大值
     *
     * @param nums
     * @return
     */
    public static int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //补充左右边界设为1，方便处理
        int n = nums.length;
        int[] a = new int[n + 2];
        a[0] = a[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            a[i + 1] = nums[i];
        }
        n += 2;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
            dp[i][i + 1] = 0;
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + a[i] * a[k] * a[j]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        maxCoins(new int[] {9});
    }
}
