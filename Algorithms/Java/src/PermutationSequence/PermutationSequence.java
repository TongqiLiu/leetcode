package src.PermutationSequence;

import java.util.ArrayList;

/**
 * @author mingqiao
 * @Date 2019/12/30
 */
public class PermutationSequence {

    /**
     * 可以逐个数字递推出k这个位置应该放的是什么
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        if (n <= 0 || k <= 0) {
            return null;
        }

        ArrayList<Integer> list = new ArrayList<>();
        k--;
        for (int i = n - 1; i >= 0; i--) {
            int fact = factorial(i);

            int temp = k / fact;
            for (int j = 1; j <= n; j++) {
                if (!list.contains(j)) {
                    temp--;
                    if (temp < 0) {
                        list.add(j);
                        break;
                    }
                }
            }
            k = k % fact;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append(list.get(i));
        }
        return res.toString();
    }

    public int factorial(int n) {
        int fact = 1;
        for (int i = n; i >= 1; i--) {
            fact *= i;
        }
        return fact;
    }
}
