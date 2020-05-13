package src.MissingRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/3/10
 */
public class MissingRanges {

    /**
     * 记录一个左边界指针不断右移，复杂度O(N)
     *
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        long left = lower;
        for (int i = 0; i < nums.length; i++) {
            if (left + 1 == nums[i]) {
                ans.add(String.valueOf(left));
            } else if (left + 1 < nums[i]) {
                ans.add(left + "->" + (nums[i] - 1));
            }
            left = (long)nums[i] + 1;
        }
        // 右边界
        if (left == upper) {
            ans.add(String.valueOf(left));
        } else if (left < upper) {
            ans.add(left + "->" + upper);
        }
        return ans;
    }
}
