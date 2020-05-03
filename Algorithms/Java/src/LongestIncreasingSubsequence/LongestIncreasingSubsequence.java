package src.LongestIncreasingSubsequence;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/2/2
 */
public class LongestIncreasingSubsequence {

    /**
     * O(N ^ 2)实现的LIS问题
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length, ans = 0;
        int dp[] = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = Math.max(dp[i], 1);
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    /**
     * dp+二分，dp[i]表示i+1长度的子数组最小值为多少，二分查找之后每个元素如果比右边界替换其右边界
     * 复杂度O(N * logN)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            int lower = lowerBound(dp, nums[i]);
            dp[lower] = nums[i];
        }

        return lowerBound(dp, Integer.MAX_VALUE);
    }

    /**
     * 找到数组里第一个>=target的位置
     *
     * @param dp
     * @param target
     * @return
     */
    private static int lowerBound(int[] dp, int target) {
        int l = 0, r = dp.length - 1, pos = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (dp[mid] < target) {
                l = mid + 1;
            } else {
                if (dp[mid] == target) {
                    pos = mid;
                }

                r = mid - 1;
            }
        }
        return pos == -1 ? l : pos;
    }

    //public static void main(String[] args) {
    //    System.out.println(lowerBound(new int[] {1, 1, 1, 1}, 1));
    //}
}
