package src.Combinations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/1/7
 */
public class Combinations {

    /**
     * 可以使用dfs搜索，这里可以利用下数学：C(n, k) = C(n-1, k-1) + C(n-1, k)，
     * 即可以由两个集合的结果叠加而来
     *
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0) {
            List<Integer> list = new ArrayList<>();
            return new ArrayList<>(Collections.singletonList(list));
        }
        if (n == k) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= k; i++) {
                list.add(i);
            }
            return new ArrayList<>(Collections.singletonList(list));
        }

        List<List<Integer>> result = combine(n - 1, k - 1);
        result.forEach(v -> v.add(n));

        result.addAll(combine(n - 1, k));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2).toString());
    }
}
