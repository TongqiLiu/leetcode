package src.SerializeAndDeserializeBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/3/6
 */
public class SerializeAndDeserializeBinaryTree {

    /**
     * bfs分层先序遍历
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    sb.append("null,");
                } else {
                    sb.append(cur.val);
                    sb.append(",");
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }
        }
        return sb.substring(0, sb.length() - 1) + "]";
    }

    /**
     * 同理反序列化回来
     *
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.equals("[]")) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] datas = data.split(",");

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(datas[0]));
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < data.length()) {
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                TreeNode cur = queue.poll();
                TreeNode left = null, right = null;
                if (!"null".equals(datas[i])) {
                    left = new TreeNode(Integer.valueOf(datas[i]));
                }
                if (!"null".equals(datas[i + 1])) {
                    right = new TreeNode(Integer.valueOf(datas[i + 1]));
                }

                cur.left = left;
                cur.right = right;
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
                i += 2;
            }
        }
        return root;
    }
}
