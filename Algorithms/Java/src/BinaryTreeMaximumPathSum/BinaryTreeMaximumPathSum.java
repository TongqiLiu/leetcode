package src.BinaryTreeMaximumPathSum;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/2/1
 */
public class BinaryTreeMaximumPathSum {

    private static int ans = Integer.MIN_VALUE;

    /**
     * dfs，对当前节点分三种case考虑：走左，走右，从左走到右，取这三种累计和的最大值即可
     * @param root
     * @return
     */
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        int res = Math.max(left, right);

        ans = Math.max(ans, left + right + root.val);
        return res + root.val;
    }

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dfs(root);

        return ans;
    }
}
