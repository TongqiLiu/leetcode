package src.RottingOranges;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

/**
 * @author mingqiao
 * @Date 2020/3/4
 */
public class RottingOranges {

    private int[] dx = new int[] {-1, 0, 1, 0};
    private int[] dy = new int[] {0, -1, 0, 1};

    /**
     * 标准的bfs题，复杂度O(M * N)
     *
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        int row = grid.length, col = grid[0].length;

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 2) {
                    int p = r * col + c;
                    queue.add(new Pair<>(p, 0));
                }
            }
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int p = pair.getKey();
            int dep = pair.getValue();
            int r = p / col, c = p % col;

            for (int k = 0; k < 4; ++k) {
                int nx = r + dx[k];
                int ny = c + dy[k];
                if (0 <= nx && nx < row && 0 <= ny && ny < col && grid[nx][ny] == 1) {
                    grid[nx][ny] = 2;

                    int np = nx * col + ny;
                    int ndep = dep + 1;
                    queue.add(new Pair<>(np, ndep));
                    ans = ndep;
                }
            }
        }

        for (int[] rows : grid) {
            if (Arrays.stream(rows).boxed().anyMatch(v -> v == 1)) {
                return -1;
            }
        }
        return ans;
    }
}
