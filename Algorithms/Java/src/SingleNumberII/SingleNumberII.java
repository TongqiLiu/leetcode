package src.SingleNumberII;

/**
 * @author mingqiao
 * @Date 2020/2/29
 */
public class SingleNumberII {

    /**
     * 异或满足交换律，且：0 ^ x = x，x ^ x = 0,x & ~x = 0, x & ~0 = x
     * 故设定两数让两数三次异或变成：00->01->10->00
     * 这里前两次异或时一个为x时另一个为0，第三次刚好就能消掉了
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            a = (a ^ nums[i]) & ~b;
            b = (b ^ nums[i]) & ~a;
        }
        return a;
    }
}
