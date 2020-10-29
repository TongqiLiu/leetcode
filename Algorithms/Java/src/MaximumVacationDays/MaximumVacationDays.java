package src.MaximumVacationDays;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/10/28
 */
public class MaximumVacationDays {

    /**
     * 题目地址：https://leetcode-cn.com/problems/maximum-vacation-days/
     * dp[k][n]表示第k周结束时停留在城市n能休假的最长天数，时间复杂度O(K * N ^ 2)
     *
     * @param flights
     * @param days
     * @return
     */
    public int maxVacationDays(int[][] flights, int[][] days) {
        int N = flights.length;
        int K = days[0].length;
        int[][] dp = new int[K][N];

        for (int i = 0; i < N; i++) {
            flights[i][i] = 1;
        }

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        //初始化第一周
        for (int i = 0; i < N; i++) {
            if (flights[0][i] != 0) {
                dp[0][i] = days[i][0];
            }
        }

        for (int k = 1; k < K; k++) {

            //i表示当前城市，j表示上一个城市
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (flights[j][i] == 1 && dp[k - 1][j] >= 0) {
                        dp[k][i] = Math.max(dp[k][i], dp[k - 1][j] + days[i][k]);
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dp[K - 1][i]);
        }
        return ans;
    }
}
