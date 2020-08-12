package src.ConstructBinaryTreefromInorderandPostorderTraversal;

import java.util.HashMap;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/8/11
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {

    private HashMap<Integer, Integer> map = new HashMap<>();

    /**
     * 题目地址：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
     * 对每颗子树而言，后序数组根节点在尾部，而中序数组根节点左边是左子树，右边是右子树，再根据子树个数递归解决即可，注意左右边界不要越界
     *
     * @param postorder
     * @param postStart
     * @param postEnd
     * @param inStart
     * @return
     */
    private TreeNode dfs(int[] postorder, int postStart, int postEnd, int inStart) {
        if (postStart > postEnd) {
            return null;
        }
        if (postStart == postEnd) {
            return new TreeNode(postorder[postEnd]);
        }
        //查询根节点位置及左右子树节点数
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = map.get(rootValue);
        int leftNum = rootIndex - inStart;
        //System.out.println("postStart:" + postStart + ", postEnd:" + postEnd + ", inStart:" + inStart + ", inEnd:" + inEnd + ", leftNum:" + leftNum);
        root.left = dfs(postorder, postStart, postStart + leftNum - 1, inStart);
        root.right = dfs(postorder, postStart + leftNum, postEnd - 1, rootIndex + 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        map.clear();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(postorder, 0, postorder.length - 1, 0);
    }
}
