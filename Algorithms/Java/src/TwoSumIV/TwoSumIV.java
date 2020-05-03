package src.TwoSumIV;

import java.util.HashSet;
import java.util.Set;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/2/29
 */
public class TwoSumIV {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }

    /**
     * 先序遍历，复杂度O(N)
     *
     * @param root
     * @param k
     * @param set
     * @return
     */
    public boolean dfs(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return dfs(root.left, k, set)
            || dfs(root.right, k, set);
    }
}
