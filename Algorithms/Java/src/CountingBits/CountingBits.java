package src.CountingBits;

/**
 * @author mingqiao
 * @Date 2020/2/6
 */
public class CountingBits {

    /**
     * 奇数一定比前一个偶数多1，偶数一定和其/2数一样多
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= num; i++) {
            if ((i & 1) != 0) {
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = res[i / 2];
            }
        }
        return res;
    }
}
