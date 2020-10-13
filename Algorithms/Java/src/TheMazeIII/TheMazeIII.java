package src.TheMazeIII;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author mingqiao
 * @Date 2020/10/13
 */
public class TheMazeIII {

    private int dx[] = {0, 0, -1, 1};
    private int dy[] = {1, -1, 0, 0};
    private String p[] = {"r", "l", "u", "d"};

    /**
     * 题目地址：https://leetcode-cn.com/problems/the-maze-iii/
     * 加了字典序的最短路，注意一些细节比如进洞之后不能再入队了，时间复杂度O(N * M * log(M * N))
     *
     * @param maze
     * @param ball
     * @param hole
     * @return
     */
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        if (maze == null || maze.length == 0) {
            return "impossible";
        }
        if (ball == null || ball.length == 0 || hole == null || hole.length == 0) {
            return "impossible";
        }
        if (maze[hole[0]][hole[1]] == 1) {
            return "impossible";
        }

        int n = maze.length, m = maze[0].length;
        int[][] dis = new int[n][m];
        String[][] paths = new String[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
            Arrays.fill(paths[i], "");
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(ball[0], ball[1], 0, ""));
        dis[ball[0]][ball[1]] = 0;
        String path = "impossible";

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (dis[cur.x][cur.y] < cur.step) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i], ny = cur.y + dy[i], step = 1;
                StringBuilder np = new StringBuilder(cur.path + p[i]);
                boolean meetHole = false;

                while (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] != 1) {
                    if (nx == hole[0] && ny == hole[1]) {
                        if (dis[nx][ny] > dis[cur.x][cur.y] + step
                            || (dis[nx][ny] == dis[cur.x][cur.y] + step && paths[nx][ny].compareTo(np.toString()) > 0)) {
                            dis[nx][ny] = dis[cur.x][cur.y] + step;
                            paths[nx][ny] = np.toString();
                        }
                        meetHole = true;
                        break;
                    }

                    nx += dx[i];
                    ny += dy[i];
                    step++;
                }
                if (meetHole) {
                    continue;
                }

                nx -= dx[i];
                ny -= dy[i];
                step--;
                String npString = np.toString();

                if (dis[nx][ny] > dis[cur.x][cur.y] + step
                    || (dis[nx][ny] == dis[cur.x][cur.y] + step && paths[nx][ny].compareTo(npString) > 0)) {
                    dis[nx][ny] = dis[cur.x][cur.y] + step;
                    paths[nx][ny] = npString;
                    queue.add(new Node(nx, ny, dis[nx][ny], paths[nx][ny]));
                }
            }
        }
        return Objects.equals(paths[hole[0]][hole[1]], "") ? "impossible" : paths[hole[0]][hole[1]];
    }

    private class Node implements Comparable<Node> {
        public int x, y, step;
        public String path;

        @Override
        public int compareTo(Node o) {
            if (step == o.step) {
                return path.compareTo(o.path);
            }
            return step - o.step;
        }

        public Node(int x, int y, int step, String path) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.path = path;
        }
    }
}
