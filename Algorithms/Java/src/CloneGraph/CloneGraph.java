package src.CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author tongqi
 * @date 2025/12/28
 */
public class CloneGraph {

    /**
     * 克隆无向连通图
     * 
     * @param node 图的节点
     * @return 克隆后的图的节点
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node newNode = new Node(node.val);
        Map<Node, Node> visited = new HashMap<>();
        visited.put(node, newNode);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbor : current.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                visited.get(current).neighbors.add(visited.get(neighbor));
            }
        }   
        return newNode;
    }

    /**
     * 图的节点定义
     */
    public class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

