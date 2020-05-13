package src.MaximumLengthOfRepeatedSubarray;

public class MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return 0;
        }

        int n = A.length;
        int m = B.length;

        int ans = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = (A[i] == B[0]) ? 1 : 0;
            ans = Math.max(ans, dp[i][0]);
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = (A[0] == B[i]) ? 1 : 0;
            ans = Math.max(ans, dp[0][i]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
