package src.LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mingqiao
 * @Date 2020/2/17
 */
public class LongestConsecutiveSequence {

    /**
     * set保存所有的数，如果当前值-1不在set里则开始遍历，这样就可以避免重复，复杂度O(N * logN)
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int tmp = num;
                int len = 1;

                while (set.contains(tmp + 1)) {
                    tmp += 1;
                    len += 1;
                }
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}
