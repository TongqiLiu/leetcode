package src.TheMaze;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mingqiao
 * @Date 2020/10/13
 */
public class TheMaze {

    private int dx[] = {0, 0, -1, 1};
    private int dy[] = {1, -1, 0, 0};

    /**
     * 题目地址：https://leetcode-cn.com/problems/the-maze/
     * 经典bfs题了，复杂度O(N * M)
     *
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) {
            return false;
        }
        if (start == null || start.length == 0 || destination == null || destination.length == 0) {
            return false;
        }
        if (maze[destination[0]][destination[1]] == 1) {
            return false;
        }
        int n = maze.length, m = maze[0].length;
        boolean[] vis = new boolean[n * m];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        vis[start[0] * m + start[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1]) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i], ny = cur[1] + dy[i];

                while (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] != 1) {
                    nx += dx[i];
                    ny += dy[i];
                }

                nx -= dx[i];
                ny -= dy[i];
                if (!vis[nx * m + ny]) {
                    vis[nx * m + ny] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
        return false;
    }
}
