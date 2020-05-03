package src.WiggleSort;

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

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
