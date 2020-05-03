package src.FactorialTrailingZeroes;

/**
 * @author mingqiao
 * @Date 2020/3/8
 */
public class FactorialTrailingZeroes {

    /**
     * 2和5组成10，且有5必然有2
     * 而n! = 1 * 2 * 3 * 4 * (1 * 5) * ... * (2 * 5) * ... * (3 * 5) *... * n
     * 故ans = n / 5 + n / 25 + n / 125 + ...
     * 推广一下：求n!中因子p的个数，也可以类似计算`
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n >= 5) {
            ans += n / 5;
            n /= 5;
        }
        return ans;
    }
}
