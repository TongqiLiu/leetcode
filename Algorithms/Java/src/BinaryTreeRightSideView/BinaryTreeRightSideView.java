package src.BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/5/2
 */
public class BinaryTreeRightSideView {

    private List<Integer> ans = new ArrayList<>();

    /**
     * dfs先右后左遍历，当所在节点深度未出现时加入该首节点
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int dep) {
        if (root == null) {
            return;
        }
        if (dep == ans.size()) {
            ans.add(root.val);
        }
        dep++;
        dfs(root.right, dep);
        dfs(root.left, dep);
    }

    /**
     * bfs分层次遍历，只取每层最后一个节点
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (i == size - 1) {
                    ans.add(node.val);
                }
            }
        }
        return ans;
    }
}
