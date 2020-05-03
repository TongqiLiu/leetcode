package src.NumberOfIslands;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mingqiao
 * @Date 2020/2/7
 */
public class NumberOfIslands {

    private int dx[] = {-1, 0, 1, 0};
    private int dy[] = {0, -1, 0, 1};

    private void bfs(char[][] grid, boolean[][] vis,
                     int n, int m,
                     int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x * m + y);
        vis[x][y] = true;

        while (!queue.isEmpty()) {
            Integer pos = queue.poll();

            int cx = pos / m, cy = pos % m;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !vis[nx][ny] && grid[nx][ny] == '1') {
                    vis[nx][ny] = true;
                    queue.offer(nx * m + ny);
                }
            }
        }
    }

    /**
     * 经典问题了bfs即可
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int ans = 0;
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    bfs(grid, vis, n, m, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
}
