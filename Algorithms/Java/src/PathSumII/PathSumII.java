package src.PathSumII;

import java.util.ArrayList;
import java.util.List;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/3/2
 */
public class PathSumII {

    private List<List<Integer>> ans = new ArrayList<>();

    private void dfs(TreeNode root, int sum, List<Integer> path, int cur) {
        if (root == null) {
            return;
        }

        cur += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (cur == sum) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }

        if (root.left != null) {
            dfs(root.left, sum, new ArrayList<>(path), cur);
        }
        if (root.right != null) {
            dfs(root.right, sum, new ArrayList<>(path), cur);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans.clear();
        if (root == null) {
            return ans;
        }

        dfs(root, sum, new ArrayList<>(), 0);
        return ans;
    }
}
