package src.Candy;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/2/8
 */
public class Candy {

    /**
     * 贪心原则：
     * 1.先默认每人至少一个糖果，从左向右遍历需满足rate[i]>rate[i-1]时dp1[i]=dp1[i-1]+1的规则，反之该位置无需更新
     * 2.同上从右向左也遍历一遍，满足rate[i-1]>rate[i]时dp2[i-1]=dp2[i]+1
     * 3.此时遍历dp1和dp2，对于i位置需同时满足左右规则，即dp[i]=max(dp1[i],dp2[i])，累加即可
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int n = ratings.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp1[i] = dp1[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                dp2[i] = dp2[i + 1] + 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(dp1[i], dp2[i]);
        }
        return sum;
    }
}
