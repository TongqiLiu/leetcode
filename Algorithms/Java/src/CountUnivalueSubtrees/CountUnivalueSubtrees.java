package src.CountUnivalueSubtrees;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/2/19
 */
public class CountUnivalueSubtrees {

    private int ans;

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            ans++;
            return true;
        }

        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        if (left && right) {
            if ((root.left == null || root.val == root.left.val) &&
                (root.right == null || root.val == root.right.val)) {
                ans++;
                return true;
            }
        }
        return false;
    }

    /**
     * 当前节点被计算进去包括两种情况：
     * 1.没有子节点
     * 2.两个子节点自身也是同值子树或空，且与根节点值一样
     *
     * @param root
     * @return
     */
    public int countUnivalSubtrees(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }
}
