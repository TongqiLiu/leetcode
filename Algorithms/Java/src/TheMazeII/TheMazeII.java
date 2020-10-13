package src.TheMazeII;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author mingqiao
 * @Date 2020/10/13
 */
public class TheMazeII {

    private int dx[] = {0, 0, -1, 1};
    private int dy[] = {1, -1, 0, 0};

    /**
     * 题目地址：https://leetcode-cn.com/problems/the-maze-ii/
     * 带权bfs，易想到类似最短路spfa一样松弛即可，时间复杂度O(N * M * MAX(M, N))
     * 这里使用dijkstra堆优化的方案，时间复杂度O(N * M * log(M * N))
     *
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) {
            return -1;
        }
        if (start == null || start.length == 0 || destination == null || destination.length == 0) {
            return -1;
        }
        if (maze[destination[0]][destination[1]] == 1) {
            return -1;
        }

        int n = maze.length, m = maze[0].length;
        int[][] dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        queue.add(new int[] {start[0], start[1], 0});
        dis[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (dis[cur[0]][cur[1]] < cur[2]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i], ny = cur[1] + dy[i], step = 1;

                while (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] != 1) {
                    nx += dx[i];
                    ny += dy[i];
                    step++;
                }

                nx -= dx[i];
                ny -= dy[i];
                step--;

                if (dis[nx][ny] > dis[cur[0]][cur[1]] + step) {
                    dis[nx][ny] = dis[cur[0]][cur[1]] + step;
                    queue.add(new int[] {nx, ny, dis[nx][ny]});
                }
            }
        }
        return dis[destination[0]][destination[1]]
            == Integer.MAX_VALUE ? -1 : dis[destination[0]][destination[1]];
    }
}
