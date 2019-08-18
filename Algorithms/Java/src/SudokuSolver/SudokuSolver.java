package src.SudokuSolver;

/**
 * @author mingqiao
 * @Date 2019/8/18
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) { return; }
        dfs(board);
    }

    /**
     * 类似八皇后问题，枚举每个节的值看下全图填充方案是否合理，注意回溯时需要根据回溯结果将节点值进行更改
     * @param board
     * @return
     */
    public boolean dfs(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (valid(board, i, j, c)) {
                            board[i][j] = c;
                            if (dfs(board)) {
                                board[i][j] = c;
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    //判定该情况下棋盘是否合理
    public boolean valid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c || board[i][col] == c || board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
