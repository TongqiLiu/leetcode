package src.MinimumKnightMoves;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author mingqiao
 * @Date 2020/8/25
 */
public class MinimumKnightMoves {

    private static int[] dx = {-1, -1, 1, 1, -2, -2, 2, 2};
    private static int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
    private static int mod = 1000;

    /**
     * bfs+hash判重
     *
     * @param x
     * @param y
     * @return
     */
    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }

        Set<Integer> vis = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 0});
        vis.add(0);

        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] cur = queue.poll();
                for (int k = 0; k < dx.length; k++) {
                    int nx = cur[0] + dx[k];
                    int ny = cur[1] + dy[k];
                    int nstep = cur[2] + 1;
                    if (nx == x && ny == y) {
                        return nstep;
                    }
                    if (vis.contains(nx * mod + ny)) {
                        continue;
                    }
                    vis.add(nx * mod + ny);
                    queue.add(new int[] {nx, ny, nstep});
                }
            }
        }
        return -1;
    }
}
