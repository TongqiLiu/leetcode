package src.IntersectionOfTwoArraysII;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mingqiao
 * @Date 2020/3/16
 */
public class IntersectionOfTwoArraysII {

    /**
     * 模拟下，注意要去掉已匹配的字符
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = Arrays.stream(nums1)
            .boxed()
            .collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2)
            .boxed()
            .filter(num -> {
                if (list1.contains(num)) {
                    list1.remove(num);
                    return true;
                }
                return false;
            })
            .collect(Collectors.toList());

        int[] ans = new int[list2.size()];
        for (int i = 0; i < list2.size(); i++) {
            ans[i] = list2.get(i);
        }
        return ans;
    }
}
