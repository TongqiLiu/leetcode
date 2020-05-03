package src.DesignTicTacToe;

/**
 * @author mingqiao
 * @Date 2020/3/22
 */
public class TicTacToe {

    private int diagonal;
    private int nextDiagonal;
    private int[] rows;
    private int[] cols;
    private int size;

    /**
     * Initialize your data structure here.
     * 记录行、列、正对角线、反对角线的落子数量
     */
    public TicTacToe(int n) {
        this.size = n;
        this.rows = new int[n];
        this.cols = new int[n];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        int add = player == 1 ? 1 : -1;

        rows[row] += add;
        cols[col] += add;

        if (row == col) {
            diagonal += add;
        }
        if (row + col + 1 == size) {
            nextDiagonal += add;
        }

        if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size
            || Math.abs(diagonal) == size || Math.abs(nextDiagonal) == size) {
            return player;
        }

        return 0;
    }
}
