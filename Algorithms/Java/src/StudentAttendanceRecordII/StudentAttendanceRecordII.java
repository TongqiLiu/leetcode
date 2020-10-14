package src.StudentAttendanceRecordII;

/**
 * @author mingqiao
 * @Date 2020/10/14
 */
public class StudentAttendanceRecordII {

    private long mod = (long)1e9 + 7;

    /**
     * 题目地址：https://leetcode-cn.com/problems/student-attendance-record-ii/
     * dp[i][j][k]表示i位置为止有几个A以及末尾有连续几个L的合法方案数
     * 本解法时间复杂度O(N)，空间复杂度O(N)，这里发现i只和i-1相关，故可以使用滚动数组降维优化空间降到常数
     *
     * @param n
     * @return
     */
    public int checkRecord(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 3;
        }
        long[][][] dp = new long[n][2][3];

        //'P'、'L'
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;
        //'A'
        dp[0][1][0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][1][0] = (dp[i - 1][1][0] + dp[i - 1][0][0] + dp[i - 1][0][2] + dp[i - 1][0][1] + dp[i - 1][1][1] + dp[i - 1][1][2]) % mod;
            dp[i][1][1] = dp[i - 1][1][0];
            dp[i][1][2] = dp[i - 1][1][1];

            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % mod;
            dp[i][0][1] = dp[i - 1][0][0];
            dp[i][0][2] = dp[i - 1][0][1];
        }
        long ans = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans = (ans + dp[n - 1][i][j]) % mod;
            }
        }
        return (int)ans;
    }
}
