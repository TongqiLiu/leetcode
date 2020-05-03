package src.DiameterOfBinaryTree;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/2/15
 */
public class DiameterOfBinaryTree {

    private int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ans = 1;
        dfs(root);
        return ans - 1;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }

}
