package src.TranslateNum;

/**
 * @author mingqiao
 * @Date 2020/3/21
 */
public class TranslateNum {

    /**
     * 地址：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
     * dp或者递归求解都可以，类似斐波那契数列
     *
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int n = str.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int val = Integer.valueOf(str.substring(i - 2, i));
            if (val < 26 && val > 9) {
                //1 + 1和11两种可能
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                //只能分解成为1 + 1
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }
}
