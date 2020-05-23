package src.FriendCircles;

import java.util.HashSet;
import java.util.Set;

public class FriendCircles {

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
     * 并查集或者dfs都可以解决该问题
     *
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        if (M == null) {
            return 0;
        }

        int n = M.length;
        UnionSet unionSet = new UnionSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    unionSet.union(i + 1, j + 1);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(unionSet.find(i));
        }
        return set.size();
    }
}
