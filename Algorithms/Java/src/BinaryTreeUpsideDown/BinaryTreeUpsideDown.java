package src.BinaryTreeUpsideDown;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/2/8
 */
public class BinaryTreeUpsideDown {

    private TreeNode res;

    /**
     * 自底向上按规则重构树
     * @param root
     * @return
     */
    public TreeNode dfs(TreeNode root) {
        if (root == null || root.left == null) {
            if (res == null) {
                res = root;
            }
            return root;
        }
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);

        //调整节点
        left.left = right;
        left.right = root;

        root.left = null;
        root.right = null;
        return root;
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        res = null;
        dfs(root);
        return res;
    }
}
