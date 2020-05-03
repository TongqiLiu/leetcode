package src.PeakIndexInaMountainArray;

/**
 * @author mingqiao
 * @Date 2020/3/13
 */
public class PeakIndexInaMountainArray {

    /**
     * 寻找满足A[i] < A[i+1]的最大i
     *
     * @param A
     * @return
     */
    public int peakIndexInMountainArray(int[] A) {
        int l = 0, r = A.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (A[mid] < A[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}
