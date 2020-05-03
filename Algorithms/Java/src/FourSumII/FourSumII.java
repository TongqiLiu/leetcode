package src.FourSumII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mingqiao
 * @Date 2020/2/23
 */
public class FourSumII {

    /**
     * 枚举A、B元素集合和，复杂度O(N ^ 2)
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> abMap = new HashMap<>();
        int res = 0;

        for (int aA : A) {
            for (int aB : B) {
                int key = aA + aB;
                abMap.merge(key, 1, (pre, one) -> pre + one);
            }
        }

        for (int aC : C) {
            for (int aD : D) {
                int key = aC + aD;
                if (abMap.containsKey(0 - key)) {
                    res += abMap.get(0 - key);
                }
            }
        }
        return res;
    }
}
