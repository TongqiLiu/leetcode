package src.CheapestFlightsWithinKStops;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author mingqiao
 * @Date 2020/8/16
 */
public class CheapestFlightsWithinKStops {

    /**
     * dp[i][k]表示最多经过k个中转站后到达站i的最低费用，类似B-F的点松弛逻辑
     * 当然本题也可以使用dijkstra根据途径节点次数拆点再跑最短路求解
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param K
     * @return
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] dp = new int[n][K + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        Arrays.fill(dp[src], 0);
        //类似bellman-ford的点松弛逻辑，限定松弛次数
        for (int k = 1; k <= K + 1; k++) {
            for (int[] flight : flights) {
                int u = flight[0], v = flight[1], w = flight[2];
                if (dp[u][k - 1] != Integer.MAX_VALUE) {
                    dp[v][k] = Math.min(dp[v][k], dp[u][k - 1] + w);
                }
            }
        }
        return dp[dst][K + 1] == Integer.MAX_VALUE ? -1 : dp[dst][K + 1];
    }
}
