package src.NumberofConnectedComponentsInAnUndirectedGraph;

/**
 * @author mingqiao
 * @Date 2020/2/26
 */
public class NumberofConnectedComponentsInAnUndirectedGraph {

    private class UnionSet {

        private int[] fa;
        private int n;

        public UnionSet(int n) {
            this.n = n;
            fa = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                fa[i] = i;
            }
        }

        public int find(int x) {
            if (x == fa[x]) {
                return x;
            }
            return fa[x] = find(fa[x]);
        }

        public void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx != fy) {
                fa[fx] = fy;
            }
        }
    }

    /**
     * 并查集应用，也可以使用tarjan算法缩点查询
     *
     * @param n
     * @param edges
     * @return
     */
    public int countComponents(int n, int[][] edges) {
        if (n == 0 || edges == null) {
            return 0;
        }

        int ans = 0;
        UnionSet unionSet = new UnionSet(n);
        for (int i = 0; i < edges.length; i++) {
            unionSet.union(edges[i][0], edges[i][1]);
        }
        for (int i = 0; i < n; i++) {
            int fi = unionSet.find(i);
            if (fi == i) {
                ans++;
            }
        }
        return ans;
    }
}
