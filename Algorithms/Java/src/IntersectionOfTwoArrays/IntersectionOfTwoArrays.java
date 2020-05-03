package src.IntersectionOfTwoArrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mingqiao
 * @Date 2020/3/16
 */
public class IntersectionOfTwoArrays {

    /**
     * set模拟下
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }

        int i = 0;
        int[] ans = new int[set2.size()];
        for (int num : set2) {
            ans[i++] = num;
        }
        return ans;
    }
}
