package src.Subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/1/7
 */
public class Subsets {

    private static List<List<Integer>> ans = new ArrayList<>();

    /**
     * 1.dfs，复杂度O(n!)
     *
     * @param nums
     * @param dep
     */
    private static void dfs(int[] nums, int dep) {
        if (dep >= nums.length) {
            return;
        }

        int size = ans.size();
        for (int i = 0; i < size; i++) {
            List<Integer> list = new ArrayList<>(ans.get(i));
            list.add(nums[dep]);
            ans.add(list);
        }
        List<Integer> singleList = new ArrayList<>();
        singleList.add(nums[dep]);
        ans.add(singleList);
        dfs(nums, dep + 1);
    }

    /**
     * 2.状态压缩，选与不选各是一个集合，复杂度O(2 ^ n * n)
     *
     * @param nums
     * @return
     */
    private static List<List<Integer>> bitSearch(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1) {
                    System.out.println("i: " + i + ", j: " + j + ", i >> j: " + (i >> j));
                    sub.add(nums[j]);
                }
            }
            res.add(sub);
        }
        return res;
    }

    public static List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        //ans.clear();
        //dfs(nums, 0);
        //ans.add(new ArrayList<>());
        //return ans;

        return bitSearch(nums);
    }

    public static void main(String[] args) {
        subsets(new int[] {1, 2, 3});
    }
}
