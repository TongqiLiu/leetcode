package src.SearchInsertPosition;

/**
 * @author mingqiao
 * @Date 2019/8/4
 */
public class SearchInsertPosition {

    /**
     * lowerbound实现，找得到就返回位置，找不到返回游标
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        return lowerBound(nums, target);
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
        return pos != -1 ? pos : l;
    }
}
