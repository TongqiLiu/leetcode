package src.CountNumberOfNiceSubarrays;

/**
 * @author mingqiao
 * @Date 2020/4/23
 */
public class CountNumberOfNiceSubarrays {

    /**
     * 滑动窗口，维护一个拥有K个奇数的区间段[l, r)，复杂度O(N)
     * 第 1 个奇数左边的 leftEven 个偶数都可以作为目标的起点
     * 第 k 个奇数右边的 rightEven 个偶数都可以作为目标的终点
     *
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int l = 0, r = 0, odd = 0, ans = 0;
        while (r < nums.length) {
            if ((nums[r++] & 1) == 1) {
                odd++;
            }

            if (odd == k) {

                int tmp = r;
                while (r < nums.length && (nums[r] & 1) == 0) {
                    r++;
                }
                int rightEven = r - tmp;

                int leftEven = 0;
                while ((nums[l] & 1) == 0) {
                    leftEven++;
                    l++;
                }
                l++;

                ans += (leftEven + 1) * (rightEven + 1);
                odd--;
            }
        }
        return ans;
    }
}
