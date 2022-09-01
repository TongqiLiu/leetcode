package src.LongestUnivaluePath;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2022/9/2
 */
public class LongestUnivaluePath {

    int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left), right = dfs(root.right);
        int lmax = 0, rmax = 0;
        if (root.left != null && root.left.val == root.val) {
            lmax = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            rmax = right + 1;
        }
        ans = Math.max(ans, lmax + rmax);
        return Math.max(lmax, rmax);
    }
}
