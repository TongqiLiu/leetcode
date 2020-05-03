package src.FourKeysKeyboard;

/**
 * @author mingqiao
 * @Date 2020/2/23
 */
public class FourKeysKeyboard {

    /**
     * 每次按键有追加及复制两种变长的方法，可以枚举乘法出现的位置，复杂度O(N ^ 2)
     * 另外我们分析如果做>2N次乘法，则需要2N+1次操作，既然这样当然可以转化为先乘N+1次，
     * 然后结果乘2，一共也只需要N+5次操作，故连乘不会超过5次，故也可以优化下
     *
     * @param N
     * @return
     */
    public int maxA(int N) {
        if (N <= 0) {
            return 0;
        }

        int[] dp = new int[N + 1];
        for (int k = 1; k <= N; ++k) {
            dp[k] = dp[k - 1] + 1;
            for (int x = 0; x < k - 1; ++x) {
                dp[k] = Math.max(dp[k], dp[x] * (k - x - 1));
            }
        }
        return dp[N];
    }
}
