package src.ReverseBits;

/**
 * @author mingqiao
 * @Date 2020/3/20
 */
public class ReverseBits {

    /**
     * 一位一位来
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            //取出最低位
            int temp = n >> i;
            temp &= 1;

            //反向|上去
            temp <<= (31 - i);
            res |= temp;
        }
        return res;
    }
}
