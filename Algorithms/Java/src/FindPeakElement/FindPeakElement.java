package src.FindPeakElement;

/**
 * @author mingqiao
 * @Date 2020/3/3
 */
public class FindPeakElement {

    /**
     * 因为num[-1]=num[n]=-INF，故二分查找的那一半一定存在峰值，比如num[mid+1]>num[mid]时，那么num[mid+2]如果<num[mid+1]
     * 那么num[mid+1]就是结果，如果>num[mid+1]那证明可以继续向右，极端情况推进一直到右边界num[n]=-inf时num[n-1]就是结果
     * 复杂度O(logN)
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}
