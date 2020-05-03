package src.PopulatingNextRightPointersInEachNode;

import src.A_Common_Package.TreeNode1;

/**
 * @author mingqiao
 * @Date 2020/3/20
 */
public class PopulatingNextRightPointersInEachNode {

    /**
     * 递归下，左右子节点分别处理
     *
     * @param root
     * @return
     */
    public TreeNode1 connect(TreeNode1 root) {
        if (root == null || root.left == null) {
            return root;
        }

        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
        return root;
    }
}
