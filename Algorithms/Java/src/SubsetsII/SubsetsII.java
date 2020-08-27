package src.SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/8/27
 */
public class SubsetsII {

    private static List<List<Integer>> ans = new ArrayList<>();

    /**
     * 相邻重复元素剪掉
     *
     * @param nums
     * @param dep
     * @param temp
     */
    private static void dfs(int[] nums, int dep, ArrayList<Integer> temp) {
        if (dep > nums.length) {
            return;
        }

        ans.add(new ArrayList<>(temp));
        for (int i = dep; i < nums.length; i++) {
            //和上个数字相等就跳过
            if (i > dep && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            dfs(nums, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        ans.clear();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }
}
