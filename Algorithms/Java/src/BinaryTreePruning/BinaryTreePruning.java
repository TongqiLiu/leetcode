package src.BinaryTreePruning;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/3/24
 */
public class BinaryTreePruning {

    /**
     * 递归删除结点
     *
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            root = null;
        }
        return root;
    }
}
