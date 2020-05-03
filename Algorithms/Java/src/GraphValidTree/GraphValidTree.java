package src.GraphValidTree;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mingqiao
 * @Date 2020/3/6
 */
public class GraphValidTree {

    private class UnionSet {

        private int n;
        private int fa[];

        UnionSet(int n) {
            this.n = n;
            fa = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) {
            if (fa[x] == x) {
                return x;
            }
            return fa[x] = find(fa[x]);
        }

        boolean union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx == fy) {
                return false;
            }

            fa[fx] = fy;
            return true;
        }
    }

    /**
     * 可以通过并查集加边时查询两节点的根节点是否同一个，如果是同一个证明有环
     * 也可以通过先建图，然后BFS、DFS遍历时看看是否会访问过已走过的节点
     *
     * @param n
     * @param edges
     * @return
     */
    public boolean validTree(int n, int[][] edges) {
        if (n == 0 || edges == null) {
            return false;
        }

        UnionSet unionSet = new UnionSet(n);
        for (int[] edge : edges) {
            if (!unionSet.union(edge[0], edge[1])) {
                return false;
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(unionSet.find(i));
        }
        return set.size() == 1;
    }
}
