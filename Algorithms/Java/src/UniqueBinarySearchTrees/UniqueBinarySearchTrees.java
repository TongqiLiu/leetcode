package src.UniqueBinarySearchTrees;

/**
 * @author mingqiao
 * @Date 2020/1/14
 */
public class UniqueBinarySearchTrees {

    /**
     * 分左右两部递归算下
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int cnt = 0;
            for (int j = 0; j < i; j++) {
                cnt += dp[j] * dp[i - j - 1];
            }
            dp[i] = cnt;
        }
        return dp[n];
    }
}
