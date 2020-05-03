package src.MergeSortedArray;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/2/7
 */
public class MergeSortedArray {

    /**
     * 两数组从尾部比较，大的放在num1尾部逐渐往前挪，比从前往后挪好写很多
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }
        int index = m + n - 1;
        int tail1 = m - 1;
        int tail2 = n - 1;
        while (tail2 >= 0) {
            if (tail1 < 0) {
                nums1[index--] = nums2[tail2--];
            } else if (nums1[tail1] >= nums2[tail2]) {
                nums1[index--] = nums1[tail1--];
            } else {
                nums1[index--] = nums2[tail2--];
            }
        }
    }
}
