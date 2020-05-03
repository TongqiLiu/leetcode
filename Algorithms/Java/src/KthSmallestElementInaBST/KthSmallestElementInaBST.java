package src.KthSmallestElementInaBST;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/3/11
 */
public class KthSmallestElementInaBST {

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        return left + right + 1;
    }

    /**
     * 题目地址：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
     * 二叉搜索树特性，遍历左子树节点为left
     * 如果K<=left，则所查找节点在左子树上
     * 如果K=left + 1则为根节点
     * 否则则在右子树第k - left - 1节点上
     * 当然这题也可以中序遍历生成结果数组
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        int left = dfs(root.left);
        if (left + 1 == k) {
            return root.val;
        } else if (k <= left) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - left - 1);
        }
    }
}
