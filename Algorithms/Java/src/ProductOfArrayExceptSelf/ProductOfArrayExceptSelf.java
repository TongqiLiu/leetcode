package src.ProductOfArrayExceptSelf;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/3/15
 */
public class ProductOfArrayExceptSelf {

    /**
     * 以数为中心，其左右累计相乘计算下
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);

        int l = 1, r = 1;
        for (int i = 0; i < n; i++) {
            //左边累计值
            ans[i] *= l;
            l *= nums[i];

            //右边累计值
            ans[n - 1 - i] *= r;
            r *= nums[n - 1 - i];
        }
        return ans;
    }
}
