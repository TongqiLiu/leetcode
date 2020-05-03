package src.NthDigit;

/**
 * @author mingqiao
 * @Date 2020/3/26
 */
public class NthDigit {

    /**
     * 1字符 10个 0~9
     * 2字符 90个 10~99
     * 3字符 900个 100~999
     * 故通过不断减去位数区间定位到位数，再确定到具体的数，最后确定到数的具体某一位
     */
    public int findNthDigit(int n) {
        long bit = 1, mul = 9;

        while (n > mul * bit) {
            n -= mul * bit;
            mul *= 10;
            bit++;
        }

        String number = String.valueOf((n - 1) / bit + mul / 9);
        return number.charAt((int)((n - 1) % bit)) - '0';
    }
}
