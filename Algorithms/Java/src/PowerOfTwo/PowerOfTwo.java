package src.PowerOfTwo;

/**
 * @author mingqiao
 * @Date 2020/3/10
 */
public class PowerOfTwo {

    /**
     * lowbit算出最右边的1，如果是2的幂次方则不存在其他位置的1，注意边界和溢出
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        long nn = n;
        return (nn & (nn - 1)) == 0;
    }
}
