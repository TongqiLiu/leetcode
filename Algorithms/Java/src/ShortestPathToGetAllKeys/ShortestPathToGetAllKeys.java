package src.ShortestPathToGetAllKeys;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mingqiao
 * @Date 2020/2/26
 */
public class ShortestPathToGetAllKeys {

    private int[][] dir = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int[][][] dp;
    private int row, col;

    private class QueueNode {
        private int x;
        private int y;
        private int step;
        private int state;

        public QueueNode(int x, int y, int step, int state) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.state = state;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) { return true; }
            if (!(o instanceof QueueNode)) { return false; }

            QueueNode queueNode = (QueueNode)o;

            if (x != queueNode.x) { return false; }
            if (y != queueNode.y) { return false; }
            if (step != queueNode.step) { return false; }
            return state == queueNode.state;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            result = 31 * result + step;
            result = 31 * result + state;
            return result;
        }
    }

    private int bfs(String[] grid) {
        int end = 0;
        Queue<QueueNode> que = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i].charAt(j) == '@') {
                    que.add(new QueueNode(i, j, 0, 0));
                    dp[i][j][0] = 0;
                } else if (Character.isLowerCase(grid[i].charAt(j))) {
                    end |= 1 << (grid[i].charAt(j) - 'a');
                }
            }
        }

        while (!que.isEmpty()) {
            QueueNode curNode = que.poll();
            int x = curNode.x;
            int y = curNode.y;
            int step = curNode.step;
            int state = curNode.state;
            if (state == end) {
                return step;
            }

            for (int k = 0; k < 4; ++k) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                    char nc = grid[nx].charAt(ny);
                    if (Character.isLowerCase(nc)) {
                        int nextState = state | (1 << (nc - 'a'));
                        if (step + 1 < dp[nx][ny][nextState]) {
                            dp[nx][ny][nextState] = step + 1;
                            que.add(new QueueNode(nx, ny, step + 1, nextState));
                        }
                    } else if (nc == '.' || nc == '@'
                        || (Character.isUpperCase(nc) && (state & (1 << (nc - 'A'))) != 0)) {
                        if (step + 1 < dp[nx][ny][state]) {
                            dp[nx][ny][state] = step + 1;
                            que.add(new QueueNode(nx, ny, step + 1, state));
                        }
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 状态压缩搜索，定义dp[x][y][s]为走到(x,y)节点所持钥匙的状态，因为钥匙不超过6把，故拥有钥匙状态最多为(1 << 6) - 1种可能性，
     * 注意这里一个节点有可能重复走过，比如来回经过一个节点获取新的钥匙，但是此时s状态一定发生了变化否则这次移动无意义，
     * 广搜能否达到拥有所有钥匙的最终态即可
     *
     * @param grid
     * @return
     */
    public int shortestPathAllKeys(String[] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        row = grid.length;
        col = grid[0].length();
        dp = new int[row][col][1 << 6];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        return bfs(grid);
    }
}
