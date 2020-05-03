package src.SumRootToLeafNumbers;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/2/24
 */
public class SumRootToLeafNumbers {

    private int ans = 0;

    private void dfs(TreeNode root, int cur) {
        cur = cur * 10 + root.val;
        if (root.left == null && root.right == null) {
            ans += cur;
            return;
        }
        if (root.left != null) {
            dfs(root.left, cur);
        }
        if (root.right != null) {
            dfs(root.right, cur);
        }
    }

    /**
     * 递归左右子树，中间变量保存至叶子节点累加即可，复杂度O(N)
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return ans;
    }
}
