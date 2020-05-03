package src.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2019/12/2
 */
public class CombinationSum {

    List<List<Integer>> result = new ArrayList<>();

    /**
     * dfs爆搜即可，注意下list引用的问题
     * @param candidates
     * @param target
     * @param nowList
     * @param index
     */
    public void dfs(int[] candidates, int target, List<Integer> nowList, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(nowList));
            return;
        }

        for (int i = index; i < candidates.length && target >= candidates[i]; i++) {
            nowList.add(candidates[i]);
            dfs(candidates, target - candidates[i], nowList, i);
            nowList.remove(nowList.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result.clear();
        Arrays.sort(candidates);
        dfs(candidates, target, new ArrayList<>(), 0);
        return result;
    }
}
