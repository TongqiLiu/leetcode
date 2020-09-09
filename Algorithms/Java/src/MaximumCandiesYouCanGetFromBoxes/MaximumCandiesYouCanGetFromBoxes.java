package src.MaximumCandiesYouCanGetFromBoxes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author mingqiao
 * @Date 2020/9/9
 */
public class MaximumCandiesYouCanGetFromBoxes {

    /**
     * 地址：https://leetcode-cn.com/problems/maximum-candies-you-can-get-from-boxes/
     * bfs模拟处理
     *
     * @param status
     * @param candies
     * @param keys
     * @param containedBoxes
     * @param initialBoxes
     * @return
     */
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        //分别记录盒子是否打开，拥有的盒子和钥匙，待打开的盒子队列
        boolean[] vis = new boolean[status.length];
        Set<Integer> haveBox = new HashSet<>();
        Set<Integer> haveKey = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < initialBoxes.length; i++) {
            int idx = initialBoxes[i];
            haveBox.add(idx);
            // 如果盒子可以打开则加入队列
            if (status[idx] == 1) {
                queue.offer(idx);
                vis[idx] = true;
            }
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            ans += candies[cur];

            int[] curKeys = keys[cur];
            List<Integer> curBoxs = Arrays.stream(containedBoxes[cur]).boxed().collect(Collectors.toList());

            for (int key : curKeys) {
                haveKey.add(key);
                // 证明也能打开
                if (!vis[key] && haveBox.contains(key)) {
                    curBoxs.add(key);
                }
            }
            for (int box : curBoxs) {
                haveBox.add(box);
                // 盒子没被拆开过且盒子能打开
                if (!vis[box] && (haveKey.contains(box) || status[box] == 1)) {
                    queue.offer(box);
                    vis[box] = true;
                }
            }
        }
        return ans;
    }
}
