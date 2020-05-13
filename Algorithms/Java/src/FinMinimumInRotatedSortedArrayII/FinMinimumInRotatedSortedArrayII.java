package src.FinMinimumInRotatedSortedArrayII;

public class FinMinimumInRotatedSortedArrayII {

    /**
     * 二分解法，复杂度O(logN)
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                //目标在左区间
                right = mid;
            } else if (nums[mid] > nums[right]) {
                //目标在右区间
                left = mid;
            } else {
                right--;
            }
            // } else {
            //     return nums[mid];
            // }
        }
        return nums[left] < nums[right] ? nums[left] : nums[right];
    }
}
