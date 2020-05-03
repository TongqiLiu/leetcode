package src.ThreeSumSmaller;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/2/16
 */
public class ThreeSumSmaller {

    /**
     * 枚举每一个节点，然后双指针找出右侧区间内相加<targrt的组合，复杂度O(N ^ 2)
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int ans = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            while (l <= r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < target) {
                    //这代表这段区间的数都满足<target
                    ans += r - l;
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}
