package src.RangeSumQueryMutable;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/2/18
 */
public class NumArray {

    private int n;
    private int a[];
    private int bit[];

    private int lowBit(int x) {
        return x & (-x);
    }

    private void add(int i, int x) {
        i++;
        while (i <= n) {
            bit[i] += x;
            i += lowBit(i);
        }
    }

    private int sum(int i) {
        i++;
        int res = 0;
        while (i > 0) {
            res += bit[i];
            i -= lowBit(i);
        }
        return res;
    }

    /**
     * 树状数组或者线段树裸题：单点更新，区间查询
     *
     * @param nums
     */
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        n = nums.length;
        a = Arrays.copyOf(nums, n);
        bit = new int[n + 1];
        for (int i = 0; i < n; i++) {
            add(i, a[i]);
        }
    }

    public void update(int i, int val) {
        add(i, val - a[i]);
        a[i] = val;
    }

    public int sumRange(int i, int j) {
        return sum(j) - sum(i - 1);
    }
}
