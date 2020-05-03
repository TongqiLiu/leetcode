package src.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/1/25
 */
public class BinaryTreeLevelOrderTraversal {

    Map<Integer, List<Integer>> map = new HashMap<>();

    /**
     * dfs/bfs均可以解决该问题
     * @param root
     * @param dep
     */
    public void dfs(TreeNode root, int dep) {
        if (root == null) {
            return;
        }

        map.merge(dep, new ArrayList<Integer>() {
            {
                add(root.val);
            }
        }, (pre, one) -> {
            pre.addAll(one);
            return pre;
        });

        dfs(root.left, dep + 1);
        dfs(root.right, dep + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        map.clear();
        dfs(root, 0);

        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            ans.add(list);
        }
        return ans;
    }
}
