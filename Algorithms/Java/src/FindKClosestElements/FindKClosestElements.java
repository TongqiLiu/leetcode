package src.FindKClosestElements;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/3/27
 */
public class FindKClosestElements {

    /**
     * 地址：https://leetcode-cn.com/problems/find-k-closest-elements/
     * 最终是求一个[left，left + k)的区间，且数组有序故可以使用二分法尽可能逼近小值的区间，复杂度O(logN + K)
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (Math.abs(x - arr[mid]) > Math.abs(x - arr[mid + k])) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
