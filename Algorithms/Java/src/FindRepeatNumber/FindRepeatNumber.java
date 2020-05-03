package src.FindRepeatNumber;

/**
 * @author mingqiao
 * @Date 2020/3/24
 */
public class FindRepeatNumber {

    /**
     * 把出现过的数索引位置置为负数，时间复杂度O(N)，空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i])] < 0) {
                return Math.abs(nums[i]);
            }
            nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
        }
        return 0;
    }
}
