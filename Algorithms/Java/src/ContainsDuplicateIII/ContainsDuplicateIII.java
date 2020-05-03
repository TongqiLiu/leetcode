package src.ContainsDuplicateIII;

import java.util.TreeSet;

/**
 * @author mingqiao
 * @Date 2020/2/29
 */
public class ContainsDuplicateIII {

    /**
     * 维护一个treeset进行遍历查询
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 查找表中是否有[num[i] - t, num[i] + t]间的值
            Long ceiling = set.ceiling((long)nums[i] - (long)t);
            if (ceiling != null && ceiling <= ((long)nums[i] + (long)t)) {
                return true;
            }

            set.add((long)nums[i]);
            if (set.size() > k) {
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}
