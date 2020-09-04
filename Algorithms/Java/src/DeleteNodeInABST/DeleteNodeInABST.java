package src.DeleteNodeInABST;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/9/4
 */
public class DeleteNodeInABST {

    /**
     * 题目地址：https://leetcode-cn.com/problems/delete-node-in-a-bst/
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        //该节点需要删除
        else {
            //当前节点没有左子树
            if (root.left == null) {
                return root.right;
            }
            //当前节点没有右子树
            else if (root.right == null) {
                return root.left;
            } else {
                //找到右子树最小的左节点
                TreeNode node = root.right;
                while (node.left != null) {
                    node = node.left;
                }
                //该节点代替原本的root节点
                node.left = root.left;
                return root.right;
            }
        }
        return root;
    }
}
