package src.PermutationsII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mingqiao
 * @Date 2019/12/20
 */
public class PermutationsII {

    private static List<List<Integer>> ans = new ArrayList<>();
    private static Set<String> set = new HashSet<>();

    private static void dfs(int[] nums, boolean[] vis, List<Integer> list, int dep) {
        if (dep == nums.length) {
            StringBuilder stringBuilder = new StringBuilder();
            list.forEach(stringBuilder::append);
            String string = stringBuilder.toString();

            if (!set.contains(string)) {
                set.add(string);
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                list.add(nums[i]);

                dfs(nums, vis, list, dep + 1);
                vis[i] = false;
                list.remove(dep);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans.clear();
        set.clear();
        boolean[] vis = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        dfs(nums, vis, list, 0);
        return ans;
    }
}
