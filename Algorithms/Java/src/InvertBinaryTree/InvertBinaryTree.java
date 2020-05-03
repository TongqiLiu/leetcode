package src.InvertBinaryTree;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/2/6
 */
public class InvertBinaryTree {

    /**
     * 递归构造
     * @param root
     * @return
     */
    public TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode invertRoot = new TreeNode(root.val);
        invertRoot.left = dfs(root.right);
        invertRoot.right = dfs(root.left);
        return invertRoot;
    }

    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }
}
