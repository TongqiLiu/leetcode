package src.DivideTwoIntegers;

/**
 * author: mingqiao
 * Date: 2019/3/1
 */

//题解：任何数我们都可以写成 x = x0 * 2^0 + x1 * 2^1 + ... + xn * 2 ^ n的形式，
//    除数左移至最靠近被除数的位置算出该数，不断相减即可，复杂度O(logN)
public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long number = Math.abs(dividend), div = Math.abs(divisor), ans = 0;
        while (number >= div) {
            long tmp = div, cnt = 1;
            while (tmp << 1 < number) {
                tmp <<= 1;
                cnt <<= 1;
            }
            number -= tmp;
            ans += cnt;
        }
        return ans * sign < Integer.MAX_VALUE ? (int)ans * sign : Integer.MAX_VALUE;
    }
}
