package src.BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/3/21
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    /**
     * bfs加flag确定正反插入即可
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (flag) {
                    list.add(0, node.val);
                } else {
                    list.add(node.val);
                }
            }
            flag = !flag;
            res.add(list);
        }
        return res;
    }
}
