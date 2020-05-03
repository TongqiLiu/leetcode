package src.FactorCombinations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/3/4
 */
public class FactorCombinations {

    private static List<List<Integer>> ans = new ArrayList<>();

    private static void dfs(int curVal, int lastFactor, List<Integer> list) {
        if (list.size() >= 1) {
            list.add(curVal);
            ans.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        for (int i = lastFactor; i <= (int)(Math.sqrt(curVal)); i++) {
            if (curVal % i == 0) {
                list.add(i);
                dfs(curVal / i, i, list);
                list.remove(list.size() - 1);
            }
        }

    }

    /**
     * dfs，注意每次传递的时候将当前遍历到的质数带过去作为下界避免重复
     *
     * @param n
     * @return
     */
    public static List<List<Integer>> getFactors(int n) {
        ans.clear();
        if (n <= 1) {
            return ans;
        }

        dfs(n, 2, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        getFactors(18);
    }
}
