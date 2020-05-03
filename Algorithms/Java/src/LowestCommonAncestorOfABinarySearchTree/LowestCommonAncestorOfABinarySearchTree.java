package src.LowestCommonAncestorOfABinarySearchTree;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/2/26
 */
public class LowestCommonAncestorOfABinarySearchTree {

    /**
     * 二叉搜索树满足左子树都比根节点小，右子树都比根节点大
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
