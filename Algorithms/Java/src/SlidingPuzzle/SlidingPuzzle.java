package src.SlidingPuzzle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author mingqiao
 * @Date 2020/8/26
 */
public class SlidingPuzzle {

    //6个格子分别能交换的隔壁数字
    private static final int[][] dir = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
    private static final String end = "123450";

    /**
     * bfs暴力求解，本题可以使用A*启发式搜索利用估价函数确定优先级，可参考：
     * https://leetcode-cn.com/problems/sliding-puzzle/solution/java-chang-gui-bfs-qi-fa-shi-sou-suo-a-by-joaboo/
     *
     * @param start
     * @return
     */
    private int bfs(String start) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> vis = new HashSet<>();
        vis.add(start);

        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                String cur = queue.poll();
                int index = cur.indexOf(String.valueOf('0'));
                if (cur.charAt(index) != '0') {
                    continue;
                }
                // 获取0所在位置所有能移动的点
                for (int j : dir[index]) {
                    char[] nextValue = cur.toCharArray();
                    // 交换0和其可移动位置并生成新
                    swap(nextValue, index, j);
                    String next = new String(nextValue);
                    if (next.equals(end)) {
                        return cnt + 1;
                    }
                    if (vis.contains(next)) {
                        continue;
                    }
                    queue.offer(next);
                    vis.add(next);
                }
            }
            cnt++;
        }
        return -1;
    }

    String toString(int[][] board) {
        char[] value = new char[6];
        for (int i = 0; i < 6; i++) {
            value[i] = (char)(board[i / 3][i % 3] + '0');
        }
        return new String(value);
    }

    void swap(char[] arr, int i, int j) {
        if (i != j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public int slidingPuzzle(int[][] board) {
        String cur = toString(board);
        if (cur.equals(end)) {
            return 0;
        }
        return bfs(cur);
    }
}
