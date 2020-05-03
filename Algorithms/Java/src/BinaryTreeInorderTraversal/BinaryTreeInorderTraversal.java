package src.BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/1/14
 */
public class BinaryTreeInorderTraversal {

    /**
     * 递归写法
     *
     * @param root
     * @param list
     */
    public void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
        return;
    }

    /**
     * 非递归
     * @param root
     * @param list
     */
    public void stack(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //dfs(root, list);
        stack(root, list);
        return list;
    }
}
