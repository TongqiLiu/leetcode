package src.RangeAddition;

/**
 * @author mingqiao
 * @Date 2020/3/11
 */
public class RangeAddition {

    /**
     * 题目地址：https://leetcode-cn.com/problems/range-addition/
     * 还是利用前缀和思想，对于一次区间[l,r]增量操作，累计维护两端点的增量和，复杂度O(N)
     *
     * @param length
     * @param updates
     * @return
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] sum = new int[length + 1];
        for (int[] update : updates) {
            int l = update[0];
            int r = update[1];
            int k = update[2];

            sum[l] += k;
            if (r + 1 < length) {
                sum[r + 1] -= k;
            }
        }
        for (int i = 1; i < length; i++) {
            sum[i] = sum[i] + sum[i - 1];
        }
        return sum;
    }
}
