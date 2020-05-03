package src.ConvertBSTToGreaterTree;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/3/2
 */
public class ConvertBSTToGreaterTree {

    private int sum = 0;

    /**
     * 中序遍历BST本身就是有小到大，那么反过来就是由大到小累加了
     *
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
