package src.AvailableCapturesForRook;

/**
 * @author mingqiao
 * @Date 2020/3/26
 */
public class AvailableCapturesForRook {

    /**
     * 模拟题
     *
     * @param board
     * @return
     */
    public int numRookCaptures(char[][] board) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    int res = 0;
                    for (int k = 0; k < 4; k++) {

                        int x = i, y = j;
                        while (true) {
                            x += dx[k];
                            y += dy[k];
                            if (x < 0 || x >= 8 || y < 0 || y >= 8 || board[x][y] == 'B') {
                                break;
                            }
                            if (board[x][y] == 'p') {
                                res++;
                                break;
                            }
                        }
                    }
                    return res;
                }
            }
        }
        return 0;
    }
}
