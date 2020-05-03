package src.ValidateBinarySearchTree;

import java.util.List;
import java.util.Stack;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/1/14
 */
public class ValidateBinarySearchTree {

    /**
     * 递归处理，注意边界判定
     *
     * @param root
     * @param min
     * @param max
     * @return
     */
    public boolean dfs(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }

    /**
     * 非递归
     *
     * @param root
     */
    public boolean stack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        Long min = Long.MIN_VALUE;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.val <= min) {
                return false;
            }
            min = (long)cur.val;
            cur = cur.right;
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return stack(root);
        //return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {
    }
}
