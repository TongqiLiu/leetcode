package src.WiggleSortII;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/3/13
 */
public class WiggleSortII {

    /**
     * 先排序，然后分奇偶坐标构造数组
     *
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);

        int mid = (len & 1) == 1 ? len / 2 : len / 2 - 1;
        int r = len - 1;
        for (int i = 0; i < len; i++) {
            nums[i] = (i & 1) == 0 ? tmp[mid--] : tmp[r--];
        }
    }
}
