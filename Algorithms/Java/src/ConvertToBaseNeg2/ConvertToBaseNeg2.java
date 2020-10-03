package src.ConvertToBaseNeg2;

/**
 * @author mingqiao
 * @Date 2020/10/3
 */
public class ConvertToBaseNeg2 {

    /**
     * a = -b * c + d -> a = -b * (c + 1) + d + b;
     *
     * @param N
     * @return
     */
    public String baseNeg2(int N) {
        return baseK(N, -2);
    }

    /**
     * -10~10进制的转换
     *
     * @param N
     * @param K
     * @return
     */
    private String baseK(int N, int K) {
        if (N == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        while (N != 0) {
            int r = ((N % K) + Math.abs(K)) % Math.abs(K);
            res.append(r);

            N -= r;
            N /= K;
        }
        return res.reverse().toString();
    }
}
