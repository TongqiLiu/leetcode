package src.LargestBSTSubtree;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/2/8
 */
public class LargestBSTSubtree {

    private int ans = 0;
    private int pre = Integer.MIN_VALUE;

    private int getCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getCount(root.right) + getCount(root.left) + 1;
    }

    /**
     * BST满足中序遍历为从小到大的原则
     */
    private boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftFlag = isBST(root.left);
        if (pre >= root.val) {
            return false;
        }
        pre = root.val;

        boolean rightFlag = isBST(root.right);
        return leftFlag && rightFlag;
    }

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //BST判定
        pre = Integer.MIN_VALUE;
        if (isBST(root)) {
            ans = Math.max(ans, getCount(root));
        }

        largestBSTSubtree(root.left);
        largestBSTSubtree(root.right);
        return ans;
    }
}
