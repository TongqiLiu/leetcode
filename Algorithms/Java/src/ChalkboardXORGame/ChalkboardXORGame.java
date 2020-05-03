package src.ChalkboardXORGame;

/**
 * @author mingqiao
 * @Date 2020/3/25
 */
public class ChalkboardXORGame {

    /**
     * 首先我们nums数组中所有的元素进行异或操作得到xor和
     *
     * 如果xor == 0，此时小红先手，不需要进行任何操作即可获胜
     * 如果xor != 0，这时我们判断nums个数的奇偶性：
     * 如果个数为奇数，则小红必定会输，因为num ^ num = 0，即nums数组中出现偶数次的元素异或之后对xor没有影响，
     * 那么每次按照最优去元素操作，最后单出来的元素一定会被小红去掉，所以小红必输
     * 否则个数为偶数，则反之最后一个单出来的元素一定会被小明去掉，所以小明必输。
     *
     * @param nums
     * @return
     */
    public boolean xorGame(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        //只有当小红一上场就赢，或者nums的大小为偶数，小红才能赢
        if (xor == 0 || nums.length % 2 == 0) {
            return true;
        }
        return false;
    }
}
