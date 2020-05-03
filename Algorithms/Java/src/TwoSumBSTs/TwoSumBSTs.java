package src.TwoSumBSTs;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/2/29
 */
public class TwoSumBSTs {

    private boolean dfs(TreeNode root, int value) {
        if (root == null) {
            return false;
        }

        if (root.val == value) {
            return true;
        } else if (root.val < value) {
            return dfs(root.right, value);
        } else {
            return dfs(root.left, value);
        }
    }

    /**
     * 选定一颗树某节点的值，到另一个树里去寻找，复杂度O(N * logN)
     *
     * @param root1
     * @param root2
     * @param target
     * @return
     */
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null || root2 == null) {
            return false;
        }

        return dfs(root2, target - root1.val)
            || twoSumBSTs(root1.left, root2, target)
            || twoSumBSTs(root1.right, root2, target);
    }
}
