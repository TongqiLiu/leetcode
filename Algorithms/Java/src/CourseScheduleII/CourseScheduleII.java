package src.CourseScheduleII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mingqiao
 * @Date 2020/3/20
 */
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null) {
            return new int[] {};
        }
        TopoSort topoSort = new TopoSort(numCourses, prerequisites.length);
        for (int i = 0; i < prerequisites.length; i++) {
            topoSort.addEdge(prerequisites[i][1], prerequisites[i][0]);
        }

        List<Integer> result = new ArrayList<>();
        if (!topoSort.sort(numCourses, result)) {
            return new int[] {};
        }

        int[] res = new int[result.size()];
        //System.out.println("result:" + Arrays.toString(result.toArray()));
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

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

        public boolean sort(int n, List<Integer> result) {
            int tot = 0, ans = 0;
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (in[i] == 0) {
                    queue.offer(i);
                    tot++;
                }
            }

            while (!queue.isEmpty()) {
                int u = queue.poll();
                result.add(u);
                for (int i = head[u]; i != -1; i = edges[i].nxt) {
                    int v = edges[i].to;
                    --in[v];

                    if (in[v] == 0) {
                        tot++;
                        queue.offer(v);
                    }
                }
            }
            return tot == n;
        }
    }
}
