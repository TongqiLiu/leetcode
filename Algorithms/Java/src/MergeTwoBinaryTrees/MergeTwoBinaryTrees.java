package src.MergeTwoBinaryTrees;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/2/1
 */
public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        TreeNode now = new TreeNode(t1.val + t2.val);
        now.left = mergeTrees(t1.left, t2.left);
        now.right = mergeTrees(t1.right, t2.right);
        return now;
    }
}
