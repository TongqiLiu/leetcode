package src.LevelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/3/27
 */
public class LevelOrder {

    /**
     * bfs层次遍历
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return new int[] {};
        }

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
