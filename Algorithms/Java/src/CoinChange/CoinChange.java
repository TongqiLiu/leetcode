package src.CoinChange;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/2/5
 */
public class CoinChange {

    /**
     * dp或者记忆化搜索都可以，注意数组别越界
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > amount) {
                continue;
            }
            dp[coins[i]] = 1;
            for (int j = 0; j <= amount; j++) {
                if (j + coins[i] <= amount) {
                    if (dp[j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[j + coins[i]] = Math.min(dp[j + coins[i]], dp[j] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[] {1, 2, 5}, 11));
    }
}
