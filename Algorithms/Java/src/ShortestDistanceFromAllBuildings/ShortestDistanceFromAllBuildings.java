package src.ShortestDistanceFromAllBuildings;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mingqiao
 * @Date 2020/3/5
 */
public class ShortestDistanceFromAllBuildings {

    private int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    /**
     * 从每一个建筑物开始进行广搜，同时使用标记mark区分是否本次搜索走过该节点，并将每个节点到建筑物
     * 距离进行累加，最后取出最小值
     *
     * @param grid
     * @return
     */
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int ans = Integer.MAX_VALUE;

        //用来累加每一个节点到其他建筑物的距离和
        int[][] dis = new int[rows][cols];

        // 每次遍历搜索完一个建筑物将标记减小，和下次搜索区分开
        int mark = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    ans = bfs(grid, rows, cols, i, j, mark, dis);
                    mark--;
                }
            }
        }

        return ans;
    }

    private int bfs(int[][] grid, int rows, int cols, int i, int j, int mark, int[][] dis) {
        int res = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int x = cur[0];
            int y = cur[1];
            int d = cur[2];
            for (int[] dir : dir) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == mark) {
                    int nd = d + 1;
                    dis[nx][ny] += nd;
                    res = Math.min(res, dis[nx][ny]);

                    //避免节点重复访问
                    grid[nx][ny] = mark - 1;
                    queue.add(new int[] {nx, ny, nd});
                }
            }
        }
        //注意这里返回的不是全局最小值，而是本次搜索后某个节点距离其他建筑物的最小值
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
