package src.FindLeavesOfBinaryTree;

import java.util.ArrayList;
import java.util.List;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/3/9
 */
public class FindLeavesOfBinaryTree {

    private List<List<Integer>> ans = new ArrayList<>();

    public Boolean dfs(TreeNode root, List<Integer> path) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            path.add(root.val);
            return true;
        }

        if (dfs(root.left, path)) {
            root.left = null;
        }
        if (dfs(root.right, path)) {
            root.right = null;
        }
        return false;
    }

    /**
     * 递归删除叶子节点
     *
     * @param root
     * @return
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        ans.clear();
        if (root == null) {
            return ans;
        }

        while (true) {
            List<Integer> path = new ArrayList<>();
            if (dfs(root, path)) {
                break;
            }
            ans.add(path);
        }
        return ans;
    }
}
