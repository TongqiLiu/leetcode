package src.RangeSumQueryImmutable;

/**
 * @author mingqiao
 * @Date 2020/3/10
 */
public class NumArray {

    private int[] sum;

    /**
     * 维护前缀和
     *
     * @param nums
     */
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
