package src.FindFirstAndLastPositionOfElementInSortedArray;

/**
 * @author mingqiao
 * @Date 2019/7/23
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * STL中的upper_bound和lower_bound源码实现
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int l = lowerBound(nums, target);
        int r = upperBound(nums, target);
        return new int[] {l, r};
    }

    public static int lowerBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1, pos = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                if (nums[mid] == target) {
                    pos = mid;
                }

                r = mid - 1;
            }
        }
        return pos;
    }

    public static int upperBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1, pos = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] <= target) {
                if (nums[mid] == target) {
                    pos = mid;
                }

                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(upperBound(nums, 10));
        System.out.println(lowerBound(nums, 6));
    }
}
