package src.Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2019/12/19
 */
public class Permutations {

    private static List<List<Integer>> ans = new ArrayList<>();

    private static void dfs(int[] nums, boolean[] vis, List<Integer> list, int dep) {
        if (dep == nums.length) {
            ans.add(new ArrayList<>(list));
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

    public static List<List<Integer>> permute(int[] nums) {
        ans.clear();
        boolean[] vis = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        dfs(nums, vis, list, 0);
        return ans;
    }

    public static void main(String[] args) {
        permute(new int[] {1, 2, 3, 4});
        System.out.print(ans.size());
    }
}
