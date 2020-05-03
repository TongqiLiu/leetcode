package src.TreeDiameter;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/2/15
 */
public class TreeDiameter {

    public class Tree {

        private int cnt;
        private int[] head;
        private int[] dep;
        private Edge[] edges;
        private int index1, index2;

        public class Edge {
            private int to, nxt;

            Edge(int to, int nxt) {
                this.to = to;
                this.nxt = nxt;
            }

            @Override
            public String toString() {
                return "Edge{" +
                    "to=" + to +
                    ", nxt=" + nxt +
                    '}';
            }
        }

        public void addEdge(int u, int v) {
            edges[cnt] = new Edge(v, head[u]);
            head[u] = cnt++;
        }

        public Tree(int n) {
            cnt = 0;
            head = new int[n];
            Arrays.fill(head, -1);
            dep = new int[n];
            Arrays.fill(dep, -1);
            edges = new Edge[n * 2];
        }

        public void dfs(int u) {
            for (int i = head[u]; i != -1; i = edges[i].nxt) {
                int v = edges[i].to;
                if (dep[v] == -1) {
                    dep[v] = dep[u] + 1;
                    dfs(v);
                }
            }
        }

        public int findIndex(int n) {
            dep[0] = 0;
            dfs(0);
            int len = 0;
            for (int i = 0; i <= n; i++) {
                if (dep[i] > len) {
                    index1 = i;
                    len = dep[i];
                }
            }

            Arrays.fill(dep, -1);
            dep[index1] = 0;
            dfs(index1);
            for (int i = 0; i <= n; i++) {
                if (dep[i] > len) {
                    index2 = i;
                    len = dep[i];
                }
            }
            System.out.println("root i1:" + index1 + ", i2:" + index2);
            return len;
        }
    }

    /**
     * 树的直径求法：随意一节点求最长路径所在点即可找到树的一端点，然后这个端点继续求最长路径即为树的直径
     *
     * @param edges
     * @return
     */
    public int treeDiameter(int[][] edges) {
        if (edges == null || edges[0].length == 0) {
            return 0;
        }

        int n = edges.length;
        Tree tree = new Tree(n + 1);
        for (int i = 0; i < n; i++) {
            tree.addEdge(edges[i][0], edges[i][1]);
            tree.addEdge(edges[i][1], edges[i][0]);
        }
        return tree.findIndex(n);
    }
}
