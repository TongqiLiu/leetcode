/**
 * Created by tongqi on 2017/4/19.
 * Email: tongqicode@126.com
 */

//解题思路：假如两数组有序合并，我们既是找数组第(lenA + lenB + 1) / 2的那个数，偶数则是平均，我们对两数组简单画图模拟下这个二分的过程，减治处理即可，复杂度O(log(min(lenA, lenB)))

public class MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;

        int length = n + m;
        if (length % 2 == 1) return binary(nums1, n, 0, nums2, m, 0, (length + 1) / 2);
        return (binary(nums1, n, 0, nums2, m, 0, length / 2) + binary(nums1, n, 0, nums2, m, 0, (length + 1) / 2)) / 2;
    }

    public int binary(int[] A, int n, int start1, int[] B, int m, int start2, int k) {
        if (n > m) return binary(B, m, start2, A, n, start1, k);
        if (n == 0) return B[start2 + k - 1];
        if (k == 1) return Math.min(A[start1], B[start2]);

        int pa = Math.min(k / 2, n), pb = k - pa;
        if (A[start1 + pa - 1] == B[start2 + pb - 1]) return A[start1 + pa - 1];
        else if (A[start1 + pa - 1] < B[start2 + pb - 1]) return binary(A, n - pa, start1 + pa, B, m, start2, k - pa);
        else return binary(A, n, start1, B, m - pb, start2 + pb, k - pb);
    }
}
