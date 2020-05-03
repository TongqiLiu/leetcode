package src.InorderSuccessorInBST;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/3/4
 */
public class InorderSuccessorInBST {

    private TreeNode res;

    /**
     * 中序遍历过程中，寻找第一个>p节点的节点
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root, p);
        return res;
    }

    public void dfs(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        dfs(root.left, p);
        if (root.val > p.val && res == null) {
            res = root;
        }
        dfs(root.right, p);
    }
}
