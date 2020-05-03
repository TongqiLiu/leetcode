package src.GameOfLife;

/**
 * @author mingqiao
 * @Date 2020/3/19
 */
public class GameOfLife {

    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    /**
     * 使用两位的状态机来记录细胞状态，第一位表示下一状态，第二位表示当前状态：
     * 即{00, 01, 10, 11}，默认细胞下一状态为死状态
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                int lives = cal(board, i, j);
                if ((board[i][j] & 1) == 1) {
                    //死细胞->活细胞
                    if (lives >= 2 && lives <= 3) {
                        board[i][j] = 3;
                    }
                } else {
                    //活细胞->活细胞
                    if (lives == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                board[i][j] >>= 1;
            }
        }
    }

    private int cal(int[][] b, int i, int j) {
        int count = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x > b.length - 1 || y < 0 || y > b[0].length - 1) {
                continue;
            }
            //获取当前细胞状态
            count += (b[x][y] & 1);
        }
        return count;
    }
}
