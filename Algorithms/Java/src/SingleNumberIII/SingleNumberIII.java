package src.SingleNumberIII;

/**
 * @author mingqiao
 * @Date 2020/2/29
 */
public class SingleNumberIII {

    /**
     * 先求出两数的异或和，因为两数不一样所以异或后的二进制数一定起码存在一个位置为1，
     * 故以异或此位值最终为1和0分类讨论，遍历数组后得到的即是两数
     *
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        int lowBit = x & (-x);

        int[] res = new int[2];
        for (int num : nums) {
            if ((num & lowBit) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
