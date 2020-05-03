package src.PaintHouseII;

/**
 * @author mingqiao
 * @Date 2020/3/8
 */
public class PaintHouseII {

    /**
     * 由上一题我们不难推出一个O(N * M * M)的转移方程出来，那么如何达到O(N * M)复杂度呢
     * 定义刷到上一个房子i-1刷成j色最小花费为dp[i - 1][j]，那么i位置如果不刷j色则累加，
     * 如果刷了j色那么i-1即是取不刷j色的集合最小值，也即是次小值，这里滚动下优化空间
     *
     * @param costs
     * @return
     */
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length, m = costs[0].length;
        int min = Integer.MAX_VALUE, second = Integer.MAX_VALUE, color = -1;
        for (int i = 0; i < m; i++) {
            if (costs[0][i] < second) {
                if (costs[0][i] < min) {
                    second = min;
                    min = costs[0][i];
                    color = i;
                } else {
                    second = costs[0][i];
                }
            }
        }
        if (n == 1) {
            return min;
        }

        for (int i = 1; i < n; i++) {
            int preMin = min;
            int preSecond = second;
            int preColor = color;

            min = Integer.MAX_VALUE;
            second = Integer.MAX_VALUE;
            color = -1;
            for (int j = 0; j < m; j++) {
                int price = (j == preColor) ? preSecond + costs[i][j] : preMin + costs[i][j];

                if (price < second) {
                    if (price < min) {
                        second = min;
                        min = price;
                        color = j;
                    } else {
                        second = price;
                    }
                }
            }
        }
        return min;
    }
}