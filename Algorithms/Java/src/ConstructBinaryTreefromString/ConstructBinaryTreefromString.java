package src.ConstructBinaryTreefromString;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/2/13
 */
public class ConstructBinaryTreefromString {

    /**
     * 先算本节点数值，遇到左括号递归构造左子树，再遇到左括号递归构造右子树，遇到右括号返回上一层
     *
     * @param s
     * @return
     */
    public TreeNode str2tree(String s) {
        if (s == null || s.length() < 1) {
            return null;
        }
        TreeNode node = new TreeNode(0);
        dfs(node, s, 0);
        return node;
    }

    private static int dfs(TreeNode node, String string, int index) {
        int i = index;
        while ((string.charAt(i) >= '0' && string.charAt(i) <= '9') || string.charAt(i) == '-') {
            i++;
            if (i >= string.length()) {
                break;
            }
        }
        node.val = Integer.valueOf(string.substring(index, i));

        if (i < string.length() && string.charAt(i) == '(') {
            node.left = new TreeNode(0);
            i = dfs(node.left, string, i + 1);
        }
        if (i < string.length() && string.charAt(i) == '(') {
            node.right = new TreeNode(0);
            i = dfs(node.right, string, i + 1);
        }
        if (i < string.length() && string.charAt(i) == ')') {
            i++;
        }
        return i;
    }
}
