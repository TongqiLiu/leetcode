package src.SplitArrayLargestSum;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/10/15
 */
public class SplitArrayLargestSum {

    /**
     * 题目地址：https://leetcode-cn.com/problems/split-array-largest-sum/
     * 最小化最大值问题一般都使用二分解决，复杂度O(logN)
     *
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        int l = 0, r = 0;
        for (int num : nums) {
            l = Math.max(l, num);
            r += num;
        }

        int ans = r;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;

            if (splitOk(nums, mid, m)) {
                ans = Math.min(ans, mid);
                r = mid;
            } else {
                l = mid;
            }
        }
        if (splitOk(nums, r, m)) {
            ans = splitOk(nums, l, m) ? l : r;
        }
        return ans;
    }

    private boolean splitOk(int[] nums, int mid, int m) {
        int sum = 0, cnt = 1;
        for (int num : nums) {
            if (sum + num > mid) {
                sum = 0;
                cnt++;
            }
            sum += num;
        }
        return cnt <= m;
    }

    /**
     * dp[i][j]表示前i个元素分成j个子数组时最小的各数组和最大值，复杂度O(N ^ 2 * M)
     *
     * @param nums
     * @param m
     * @return
     */
    public int splitArray1(int[] nums, int m) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 1; i <= m; i++) {
            //前i个分成1组，即为前缀和
            dp[i][1] = sum[i];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                //枚举k，其中前k-1个数被分割为j-1段，而第k个数到第i个数为第j段
                for (int k = j; k <= i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k - 1][j - 1], sum[i] - sum[k - 1]));
                }
            }
        }
        return (int)dp[n][m];
    }
}
