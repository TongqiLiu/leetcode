package src.ContainsDuplicateII;

import java.util.HashSet;

/**
 * @author mingqiao
 * @Date 2020/2/29
 */
public class ContainsDuplicateII {

    /**
     * 维护一个长度为k的哈希表，如果长度>k则删除最早加入的元素
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);

            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
