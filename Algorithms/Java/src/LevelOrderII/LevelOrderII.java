package src.LevelOrderII;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/3/27
 */
public class LevelOrderII {

    /**
     * bfs层次遍历，每层作为一个循环处理一次
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> row = new LinkedList<>();

            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                row.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (row.size() > 0) {
                list.add(row);
            }
        }
        return list;
    }
}
