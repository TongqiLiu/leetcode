package src.IncreasingSubsequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mingqiao
 * @Date 2020/3/16
 */
public class IncreasingSubsequences {

    private Set<List<Integer>> result = new HashSet<>();

    /**
     * dfs搜索，set去重
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, new ArrayList<>(), 0);
        return new ArrayList<>(result);
    }

    public void dfs(int[] nums, List<Integer> path, int dep) {
        if (dep > nums.length) {
            return;
        }
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }
        for (int i = dep; i < nums.length; i++) {
            if (path.size() == 0 || nums[i] >= path.get(path.size() - 1)) {
                path.add(nums[i]);
                dfs(nums, path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
