package src.SplitArrayWithSameAverage;

import java.util.Arrays;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/10/3
 */
public class SplitArrayWithSameAverage {

    private boolean result = false;

    /**
     * 暴力dfs超时
     *
     * @param A
     * @param s1
     * @param s2
     * @param index
     */
    private void dfs(int[] A, List<Integer> s1, List<Integer> s2, int index) {
        if (index == A.length) {
            int sum1 = s1.stream().mapToInt(v -> v).sum();
            int sum2 = s2.stream().mapToInt(v -> v).sum();
            if (sum1 * s2.size() == sum2 * s1.size() && s1.size() > 0 && s2.size() > 0) {
                result = true;
            }
            return;
        }

        s1.add(A[index]);
        dfs(A, s1, s2, index + 1);
        s1.remove(s1.size() - 1);

        s2.add(A[index]);
        dfs(A, s1, s2, index + 1);
        s2.remove(s2.size() - 1);
    }

    /**
     * 由sum / n = sum1 / k = sum2 / (n - k) 知道 我们需要寻找的前缀和sum 1满足 sum * k / n = sum1
     * 故转化为01背包问题，dp[i][sum1]代表前i个数字是否能组成sum1，复杂度O(N ^ 2 * SUM)
     *
     * @param A
     * @return
     */
    public boolean splitArraySameAverage(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        int n = A.length, sum = Arrays.stream(A).sum();
        boolean[][] dp = new boolean[n][sum + 1];

        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 1; j--) {

                for (int k = sum; k > 0; k--) {
                    if ((k >= A[i]) && (dp[j - 1][k - A[i]])) {
                        dp[j][k] = true;

                        if (k * n == j * sum) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
