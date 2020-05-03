package src.ZeroOneMatrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mingqiao
 * @Date 2020/5/2
 */
public class ZeroOneMatrix {

    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    /**
     * 所有0节点作为第一层入队，分层BFS
     *
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[] {i, j});
                } else {
                    matrix[i][j] = row + col;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];

                if (nx >= 0 && nx < row && ny >= 0 && ny < col
                    && matrix[nx][ny] > matrix[p[0]][p[1]] + 1) {
                    matrix[nx][ny] = matrix[p[0]][p[1]] + 1;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
        return matrix;
    }
}
