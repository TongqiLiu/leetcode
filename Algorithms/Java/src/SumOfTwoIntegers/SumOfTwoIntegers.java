package src.SumOfTwoIntegers;

/**
 * @author mingqiao
 * @Date 2020/3/23
 */
public class SumOfTwoIntegers {

    /**
     * a ^ b计算出异或位之和，(a & b) << 1计算同位进位之和，循环累加
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
