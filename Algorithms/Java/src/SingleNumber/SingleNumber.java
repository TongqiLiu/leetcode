package src.SingleNumber;

/**
 * @author mingqiao
 * @Date 2020/2/7
 */
public class SingleNumber {

    /**
     * 同一个数^两次可以抵消掉
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            single ^= nums[i];
        }
        return single;
    }
}
