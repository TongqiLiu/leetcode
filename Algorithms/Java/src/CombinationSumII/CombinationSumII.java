package src.CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mingqiao
 * @Date 2019/12/2
 */
public class CombinationSumII {

    Set<List<Integer>> result = new HashSet<>();

    /**
     * dfs爆搜即可，游标或者标记数组都可以吧
     *
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
            dfs(candidates, target - candidates[i], nowList, i + 1);
            nowList.remove(nowList.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result.clear();
        Arrays.sort(candidates);

        dfs(candidates, target, new ArrayList<>(), 0);
        return new ArrayList<>(result);
    }
}
