package src.PathSum;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/2/24
 */
public class PathSum {

    private boolean dfs(TreeNode root, int sum, int cur) {
        if (root == null) {
            return false;
        }
        cur += root.val;
        if (root.left == null && root.right == null) {
            return cur == sum;
        }
        return dfs(root.left, sum, cur) || dfs(root.right, sum, cur);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return dfs(root, sum, 0);
    }
}
