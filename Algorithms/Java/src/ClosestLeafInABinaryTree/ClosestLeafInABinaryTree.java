package src.ClosestLeafInABinaryTree;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/2/17
 */
public class ClosestLeafInABinaryTree {

    private int ansDis;
    private int ansVal;

    public int dfs(TreeNode node, int k) {
        if (node == null) {
            return -1;
        }
        if (node.val == k) {
            findLeaf(node, 0);
            return 1;
        } else {
            int left = dfs(node.left, k);
            int right = dfs(node.right, k);
            if (left != -1) {
                findLeaf(node.right, left + 1);
                return left + 1;
            }
            if (right != -1) {
                findLeaf(node.left, right + 1);
                return right + 1;
            }
        }
        return -1;
    }

    public void findLeaf(TreeNode node, int dis) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && dis < ansDis) {
            ansDis = dis;
            ansVal = node.val;
        }
        findLeaf(node.left, dis + 1);
        findLeaf(node.right, dis + 1);
    }

    /**
     * dfs出每个节点离K的距离找不到返回-1，找到了的话则顺势找该节点的叶子节点，回溯时从其父节点的另外一颗
     * 子树寻找最近的叶子节点，复杂度O(N)
     *
     * @param root
     * @param k
     * @return
     */
    public int findClosestLeaf(TreeNode root, int k) {
        ansDis = Integer.MAX_VALUE;
        ansVal = -1;
        dfs(root, k);
        return ansVal;
    }
}
