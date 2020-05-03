package src.ParallelCourses;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mingqiao
 * @Date 2020/2/27
 */
public class ParallelCourses {

    public class TopoSort {

        private int cnt;
        private int[] head;
        private int[] in;
        private Edge[] edges;

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
            in[v]++;
        }

        public TopoSort(int n, int m) {
            cnt = 0;
            head = new int[n];
            Arrays.fill(head, -1);
            in = new int[n];
            Arrays.fill(in, 0);
            edges = new Edge[m];
        }

        public int sort(int n) {
            int tot = 0, ans = 0;
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (in[i] == 0) {
                    queue.offer(i);
                    tot++;
                }
            }

            while (!queue.isEmpty()) {
                int size = queue.size();

                while (size-- > 0) {
                    int u = queue.poll();
                    for (int i = head[u]; i != -1; i = edges[i].nxt) {
                        int v = edges[i].to;
                        --in[v];

                        if (in[v] == 0) {
                            tot++;
                            queue.offer(v);
                        }
                    }
                }
                ans++;
            }
            return tot == n ? ans : -1;
        }
    }

    /**
     * 拓扑排序，每次出队列同一层深度的所有节点，如果有环则返回-1
     *
     * @param N
     * @param relations
     * @return
     */
    public int minimumSemesters(int N, int[][] relations) {
        if (N == 0 || relations == null) {
            return 0;
        }
        TopoSort topoSort = new TopoSort(N, relations.length);
        for (int i = 0; i < relations.length; i++) {
            topoSort.addEdge(relations[i][0] - 1, relations[i][1] - 1);
        }
        return topoSort.sort(N);
    }
}
