package src.BinaryTreeVerticalOrderTraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/2/19
 */
public class BinaryTreeVerticalOrderTraversal {

    private class QueueNode {
        private int index;
        private TreeNode node;

        public QueueNode(int index, TreeNode node) {
            this.index = index;
            this.node = node;
        }
    }

    /**
     * 先序遍历，到左子树编号-1，右子树编号+1，另外用treeMap来分层保存数据集
     *
     * @param root
     * @return
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(0, root));
        while (!queue.isEmpty()) {
            QueueNode node = queue.poll();
            List<Integer> list = treeMap.merge(node.index,
                new ArrayList<>(Collections.singletonList(node.node.val))
                , (pre, one) -> {
                    pre.addAll(one);
                    return pre;
                });
            System.out.println("list:" + Arrays.toString(list.toArray()));
            treeMap.put(node.index, list);

            if (node.node.left != null) {
                queue.offer(new QueueNode(node.index - 1, node.node.left));
            }
            if (node.node.right != null) {
                queue.offer(new QueueNode(node.index + 1, node.node.right));
            }
        }

        lists = new ArrayList<>(treeMap.values());
        return lists;
    }
}
