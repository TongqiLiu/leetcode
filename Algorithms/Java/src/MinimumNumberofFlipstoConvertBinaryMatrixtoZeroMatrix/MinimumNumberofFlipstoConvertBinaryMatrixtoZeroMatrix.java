package src.MinimumNumberofFlipstoConvertBinaryMatrixtoZeroMatrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author mingqiao
 * @Date 2020/9/10
 */
public class MinimumNumberofFlipstoConvertBinaryMatrixtoZeroMatrix {

    private int[] dx = new int[] {-1, 0, 1, 0};
    private int[] dy = new int[] {0, -1, 0, 1};

    /**
     * 状态压缩的bfs，复杂度O(2 ^ MN * MN)
     *
     * @param mat
     * @return
     */
    public int minFlips(int[][] mat) {
        int state = 0, n = mat.length, m = mat[0].length;

        //状态压缩
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    state |= (1 << (i * m + j));
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        set.add(state);
        queue.offer(state);

        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                Integer curState = queue.poll();
                if (curState == 0) {
                    return ans;
                }

                //遍历每一个位置
                for (int i = 0; i <= n * m; i++) {
                    int x = i / m, y = i % m;

                    //本位置反转
                    int nextState = curState ^ (1 << i);
                    for (int j = 0; j < 4; j++) {
                        int nx = x + dx[j], ny = y + dy[j];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                            continue;
                        }
                        //相邻元素反转
                        int digit = nx * m + ny;
                        nextState ^= (1 << digit);
                    }
                    if (!set.contains(nextState)) {
                        set.add(nextState);
                        queue.offer(nextState);
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
