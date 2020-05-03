package src.MovingCount;

/**
 * @author mingqiao
 * @Date 2020/3/25
 */
public class MovingCount {

    /**
     * 地址：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
     * dfs进行判定即可
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] vis = new boolean[m][n];
        return dfs(0, 0, m, n, k, vis);
    }

    private int dfs(int i, int j, int m, int n, int k, boolean vis[][]) {
        if (i < 0 || i >= m || j < 0 || j >= n
            || (i / 10 + i % 10 + j / 10 + j % 10) > k || vis[i][j]) {
            return 0;
        }
        vis[i][j] = true;
        return dfs(i + 1, j, m, n, k, vis)
            + dfs(i - 1, j, m, n, k, vis)
            + dfs(i, j + 1, m, n, k, vis)
            + dfs(i, j - 1, m, n, k, vis) + 1;
    }
}
