package src.ConvertBinarySearchTreeToSortedDoublyLinkedList;

import java.util.Stack;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/3/24
 */
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

    private TreeNode first;
    private TreeNode last;

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return root;
        }

        dfs(root);

        first.left = last;
        last.right = first;
        return first;
    }

    /**
     * 递归写法
     *
     * @param node
     */
    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);

        if (first == null) {
            first = node;
        }
        if (last == null) {
            last = node;
        } else {
            last.right = node;
            node.left = last;
            last = node;
        }

        dfs(node.right);
    }

    /**
     * 非递归写法
     *
     * @param root
     */
    private TreeNode unDfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (first == null) {
                    first = node;
                }
                if (last == null) {
                    last = node;
                } else {
                    last.right = node;
                    node.left = last;
                    last = node;
                }

                root = node.right;
            }
        }

        first.left = last;
        last.right = first;
        return first;
    }
}
