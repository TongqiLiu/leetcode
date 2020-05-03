package src.NQueens;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2019/12/22
 */
public class NQueens {

    private static List<List<String>> result = new ArrayList<>();

    /**
     * 递归去搜索棋盘的摆置方案
     * @param board
     * @param x
     */
    private static void dfs(char[][] board, int x) {
        int n = board.length;
        int m = board[0].length;
        if (x == n) {
            add(board);
            return;
        }
        for (int j = 0; j < m; j++) {
            if (checkLegal(x, j, board)) {
                board[x][j] = 'Q';
                dfs(board, x + 1);

                board[x][j] = '.';
                //clear(board, x);
            }
        }
    }

    private static void add(char[][] board) {
        int x = board.length;
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < x; j++) {
                sb.append(board[i][j]);
            }
            resultList.add(sb.toString());
        }
        result.add(resultList);
    }

    private static void clear(char[][] board, int x) {
        int n = board.length;
        for (int i = x; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
    }

    private static boolean checkLegal(int x, int y, char[][] board) {
        if (board == null || x < 0 || y < 0) {
            return false;
        }
        int n = board.length;
        int m = board[0].length;
        if (x >= n || y >= m) {return false;}
        for (int i = 0; i < n; i++) {
            if (board[i][y] == 'Q' && i != x) {
                return false;
            }
            if (board[x][i] == 'Q' && i != y) {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Math.abs(i - x) == Math.abs(j - y)) {
                    if (board[i][j] == 'Q') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static List<List<String>> solveNQueens(int n) {
        result.clear();
        if (n <= 0) {
            return null;
        }
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(board, 0);
        return result;
    }

}
