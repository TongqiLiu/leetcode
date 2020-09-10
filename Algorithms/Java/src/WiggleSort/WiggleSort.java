package src.WiggleSort;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/3/13
 */
public class WiggleSort {

    /**
     * 模拟下题意，分位置判断下是否需要交换，因为有=号故无须考虑数字重复问题
     *
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0 && nums[i] > nums[i + 1]) || (i % 2 != 0 && nums[i] < nums[i + 1])) {
                swap(nums, i, i + 1);
            }
        }
    }

    /**
     * 先排序，然后分奇偶坐标构造数组
     *
     * @param nums
     */
    public void wiggleSort1(int[] nums) {
        int len = nums.length;
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);

        int mid = (len & 1) == 1 ? len / 2 : len / 2 - 1;
        int r = len - 1;
        //System.out.println("r:" + tmp[r]);
        for (int i = 0; i < len; i++) {
            nums[i] = (i & 1) == 0 ? tmp[mid--] : tmp[r--];
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
