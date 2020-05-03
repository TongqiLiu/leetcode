package src.MaxAreaOfIsland;

/**
 * @author mingqiao
 * @Date 2020/3/15
 */
public class MaxAreaOfIsland {

    /**
     * 经典的搜索标记问题了
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(dfs(grid, i, j), ans);
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        //已访问的岛屿不再访问
        grid[i][j] = 0;
        int cnt = 1;

        cnt += dfs(grid, i + 1, j);
        cnt += dfs(grid, i - 1, j);
        cnt += dfs(grid, i, j + 1);
        cnt += dfs(grid, i, j - 1);
        return cnt;
    }
}
