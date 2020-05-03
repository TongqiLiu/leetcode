package src.MinimumFactorization;

/**
 * @author mingqiao
 * @Date 2020/3/23
 */
public class MinimumFactorization {

    /**
     * 贪心策略，从低位起倒着枚举每一位上的数，除到无法整除为止，因式分解复杂度O(logN)
     *
     * @param a
     * @return
     */
    public int smallestFactorization(int a) {
        if (a < 2) {
            return a;
        }

        long res = 0, mul = 1;
        for (int i = 9; i >= 2; i--) {
            while (a % i == 0) {
                a /= i;
                res = mul * i + res;
                mul *= 10;
            }
        }
        return a < 2 && res <= Integer.MAX_VALUE ? (int)res : 0;
    }
}
