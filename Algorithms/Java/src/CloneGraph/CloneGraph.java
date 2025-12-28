package src.CloneGraph;

import java.util.ArrayList;
import java.util.List;

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
        // TODO: 实现克隆图的逻辑
        return null;
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

