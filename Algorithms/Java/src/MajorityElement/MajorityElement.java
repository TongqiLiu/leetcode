package src.MajorityElement;

/**
 * @author mingqiao
 * @Date 2020/2/6
 */
public class MajorityElement {

    /**
     * 不考虑排序、hash表等方法，既然一个数为众数，那么遇到该数+1，非该数-1，
     * 数组遍历下来该数数量依然>0
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ans) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                ans = nums[i + 1];
            }
        }
        return ans;
    }
}
