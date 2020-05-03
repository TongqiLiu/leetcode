package src.AsFarFromLandAsPossible;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mingqiao
 * @Date 2020/3/29
 */
public class AsFarFromLandAsPossible {

    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    /**
     * 分层bfs遍历
     *
     * @param grid
     * @return
     */
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        //没有陆地或者没有海洋
        if (queue.isEmpty() || queue.size() == n * m) {
            return -1;
        }

        int[] point = null;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                point = queue.poll();
                int x = point[0], y = point[1];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] != 0) {
                        continue;
                    }
                    grid[nx][ny] = grid[x][y] + 1;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
        return grid[point[0]][point[1]] - 1;
    }
}
