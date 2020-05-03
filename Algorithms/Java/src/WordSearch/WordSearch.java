package src.WordSearch;

/**
 * @author mingqiao
 * @Date 2020/1/8
 */
public class WordSearch {

    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    /**
     * 枚举每一个节点为起始点进行dfs搜索
     * @param board
     * @param word
     * @param row
     * @param column
     * @param vis
     * @param x
     * @param y
     * @param dep
     * @return
     */
    public boolean dfs(char[][] board, String word, int row, int column, boolean vis[][],
                       int x, int y, int dep) {
        if (dep == word.length() - 1) {
            return board[x][y] == word.charAt(dep);
        }

        if (board[x][y] == word.charAt(dep)) {
            vis[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                if (nx >= 0 && nx < row && ny >= 0 && ny < column && !vis[nx][ny]) {
                    if (dfs(board, word, row, column, vis, nx, ny, dep + 1)) {
                        return true;
                    }
                }
            }
            vis[x][y] = false;
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null) {
            return false;
        }
        int row = board.length;
        int column = board[0].length;
        boolean vis[][] = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (dfs(board, word, row, column, vis, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
