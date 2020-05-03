package src.ConstructBinaryTreefromPreorderandInorderTraversal;

import java.util.HashMap;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/1/25
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

    private HashMap<Integer, Integer> map = new HashMap<>();

    /**
     * 对每颗子树而言，先序数组首元素就是根节点，而中序数组根节点左边是左子树，右边是右子树，递归解决即可，注意左右边界不要越界
     *
     * @param preorder
     * @param preStart
     * @param preEnd
     * @param inStart
     * @return
     */
    private TreeNode dfs(int[] preorder, int preStart, int preEnd, int inStart) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        //查询根节点位置及左右子树节点数
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = map.get(rootValue);
        int leftNum = rootIndex - inStart;
        //System.out.println("preStart:" + preStart + ", preEnd:" + preEnd + ", inStart:" + inStart + ", inEnd:" + inEnd + ", leftNum:" + leftNum);
        root.left = dfs(preorder, preStart + 1, preStart + leftNum, inStart);
        root.right = dfs(preorder, preStart + leftNum + 1, preEnd, rootIndex + 1);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        map.clear();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, preorder.length - 1, 0);
    }
}
