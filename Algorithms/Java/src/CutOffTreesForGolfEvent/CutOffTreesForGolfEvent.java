package src.CutOffTreesForGolfEvent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mingqiao
 * @Date 2020/10/31
 */
public class CutOffTreesForGolfEvent {

    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};

    public int bfs(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
        int row = forest.size(), col = forest.get(0).size();
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[row][col];

        queue.add(new int[] {sx, sy, 0});
        vis[sx][sy] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == tx && cur[1] == ty) {
                return cur[2];
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dr[i];
                int ny = cur[1] + dc[i];

                if (0 <= nx && nx < row && 0 <= ny && ny < col &&
                    !vis[nx][ny] && forest.get(nx).get(ny) > 0) {
                    vis[nx][ny] = true;
                    queue.add(new int[] {nx, ny, cur[2] + 1});
                }
            }
        }
        return -1;
    }

    /**
     * 题目地址：https://leetcode-cn.com/problems/cut-off-trees-for-golf-event/
     * 先按照树的高度排序排出到达节点顺序，再bfs逐个check先后两节点距离
     * 时间复杂度O((row * col) ^ 2)
     *
     * @param forest
     * @return
     */
    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();
        for (int r = 0; r < forest.size(); r++) {
            for (int c = 0; c < forest.get(0).size(); c++) {
                int v = forest.get(r).get(c);
                if (v > 1) {
                    trees.add(new int[] {v, r, c});
                }
            }
        }
        trees.sort(Comparator.comparingInt(a -> a[0]));

        int ans = 0, sx = 0, sy = 0;
        for (int[] tree : trees) {
            int dis = bfs(forest, sx, sy, tree[1], tree[2]);
            if (dis < 0) {
                return -1;
            }

            ans += dis;
            sx = tree[1];
            sy = tree[2];
        }
        return ans;
    }
}
