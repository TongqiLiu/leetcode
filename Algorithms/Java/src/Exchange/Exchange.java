package src.Exchange;

/**
 * @author mingqiao
 * @Date 2020/3/24
 */
public class Exchange {

    /**
     * 类似快排的思路，复杂度O(logN)
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }
}
