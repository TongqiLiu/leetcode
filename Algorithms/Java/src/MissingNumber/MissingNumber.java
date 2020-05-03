package src.MissingNumber;

/**
 * @author mingqiao
 * @Date 2020/2/29
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ (i + 1) ^ nums[i];
        }
        return ans;
    }
}
