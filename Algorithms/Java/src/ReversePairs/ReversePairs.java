package src.ReversePairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author mingqiao
 * @Date 2020/3/20
 */
public class ReversePairs {

    private class Bit {

        private int[] bit;
        private int n;

        public Bit(int n) {
            this.n = n;
            bit = new int[n + 1];
        }

        private int lowBit(int i) {
            return i & (-i);
        }

        public void update(int i, int x) {
            while (i <= n) {
                bit[i] += x;
                i += lowBit(i);
            }
        }

        public int sum(int i) {
            int res = 0;
            while (i > 0) {
                res += bit[i];
                i -= lowBit(i);
            }
            return res;
        }
    }

    /**
     * 树状数组解法
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        int rank = 1;
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (Integer number : set) {
            rankMap.put(number, rank++);
        }

        int res = 0;
        Bit bit = new Bit(n);
        for (int i = n - 1; i >= 0; i--) {
            rank = rankMap.get(nums[i]);

            res += bit.sum(rank - 1);
            bit.update(rank, 1);
        }
        return res;
    }

    /**
     * 分治解法：归并排序，归并过程中不断计算逆序数
     *
     * @param nums
     * @return
     */
    public int reversePairs1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }

    private int res;

    private void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, index = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[index++] = arr[i++];
            } else {
                //该区间全都是逆序数
                temp[index++] = arr[j++];
                res += mid - i + 1;
            }
        }
        while (i <= mid) {
            temp[index++] = arr[i++];
        }
        while (j <= right) {
            temp[index++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}
