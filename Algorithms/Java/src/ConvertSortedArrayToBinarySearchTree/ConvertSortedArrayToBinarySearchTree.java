package src.ConvertSortedArrayToBinarySearchTree;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/3/18
 */
public class ConvertSortedArrayToBinarySearchTree {

    /**
     * 中序遍历的构造方法
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return nums == null ? null : dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, l, mid - 1);
        root.right = dfs(nums, mid + 1, r);
        return root;
    }
}
