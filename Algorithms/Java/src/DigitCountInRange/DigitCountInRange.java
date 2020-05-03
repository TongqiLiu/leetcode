package src.DigitCountInRange;

/**
 * @author mingqiao
 * @Date 2020/2/21
 */
public class DigitCountInRange {

    /**
     * 计算逻辑类似NumberOfDigitOne
     *
     * @param d
     * @param low
     * @param high
     * @return
     */
    public int digitsCount(int d, int low, int high) {
        return (int)(count(high, d) - count(low - 1, d));
    }

    /**
     * 通过找规律可以递推计算出个位、十位、百位...x出现的次数，注意0需要特判下因为没有0作为高位
     *
     * @param n
     * @param x
     * @return
     */
    long count(int n, int x) {
        long cnt = 0, tmp = n;
        for (long i = 1; tmp > 0; i *= 10, tmp = n / i) {
            long high = tmp / 10;
            if (x == 0) {
                if (high > 0) {
                    high--;
                } else {
                    break;
                }
            }
            cnt += high * i;
            long mod = tmp % 10;
            if (mod > x) {
                cnt += i;
            } else if (mod == x) {
                //算出更低一位的数字
                cnt += n % i + 1;
            }
        }
        return cnt;
    }
}
