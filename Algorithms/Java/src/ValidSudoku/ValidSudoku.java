package src.ValidSudoku;

/**
 * @author mingqiao
 * @Date 2019/8/4
 */
public class ValidSudoku {

    /**
     * 模拟即可，横向、竖向以及9宫格数组标记下
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] rows = new boolean[m][9];
        boolean[][] columns = new boolean[n][9];
        boolean[][] squares = new boolean[(int)((long)m * n / 9)][9];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    int val = board[i][j] - '1';
                    if (!rows[i][val] && !columns[j][val] && !squares[3 * (i / 3) + j / 3][val]) {
                        rows[i][val] = columns[j][val] = squares[3 * (i / 3) + j / 3][val] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
