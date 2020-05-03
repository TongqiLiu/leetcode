package src.SortedMergeLCCI;

/**
 * @author mingqiao
 * @Date 2020/3/3
 */
public class SortedMergeLCCI {

    /**
     * 从后向前合并
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int p = m + n - 1, pa = m - 1, pb = n - 1;
        while (pa >= 0 && pb >= 0) {
            if (A[pa] >= A[pb]) {
                A[p--] = A[pa--];
            } else {
                A[p--] = B[pb--];
            }
        }
        while (pb >= 0) {
            A[p--] = B[pb--];
        }
    }
}
