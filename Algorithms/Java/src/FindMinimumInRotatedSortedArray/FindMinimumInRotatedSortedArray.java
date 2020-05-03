package src.FindMinimumInRotatedSortedArray;

/**
 * @author mingqiao
 * @Date 2020/3/28
 */
public class FindMinimumInRotatedSortedArray {

    /**
     * 二分解法，复杂度O(logN)
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                //目标在左区间
                right = mid;
            } else if (nums[mid] > nums[right]) {
                //目标在右区间
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
