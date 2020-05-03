package src.SymmetricTree;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/1/25
 */
public class SymmetricTree {

    /**
     * 视为两棵树来左右分别比较，时间复杂度O(N)
     * @param left
     * @param right
     * @return
     */
    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if(left.val != right.val) {
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        return dfs(root, root);
    }
}
