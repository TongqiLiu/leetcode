package src.LowestCommonAncestorOfABinaryTree;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/2/26
 */
public class LowestCommonAncestorOfABinaryTree {

    /**
     * 如果找到p或者q就返回，直到某个父节点向下找p、q均不为空时它就是最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
