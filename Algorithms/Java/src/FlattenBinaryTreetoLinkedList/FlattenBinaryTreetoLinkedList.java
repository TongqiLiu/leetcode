package src.FlattenBinaryTreetoLinkedList;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/2/1
 */
public class FlattenBinaryTreetoLinkedList {

    /**
     * 模拟有两个步骤：1.左子树接到原本右子树的地方，2.原右子树接到新左子树下面，不断找到新的根节点重复1，2步骤
     * @param root
     */
    public void flatten(TreeNode root) {
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }
}
