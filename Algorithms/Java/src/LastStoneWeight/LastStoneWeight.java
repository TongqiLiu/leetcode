package src.LastStoneWeight;

import java.util.PriorityQueue;

/**
 * @author mingqiao
 * @Date 2020/3/25
 */
public class LastStoneWeight {

    /**
     * 模拟维护一个大顶堆，复杂度O(N * logN)
     *
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : stones) {
            queue.offer(i);
        }
        while (queue.size() >= 2) {
            int x = queue.poll();
            int y = queue.poll();
            if (x > y) {
                queue.offer(x - y);
            }
        }
        return queue.size() == 1 ? queue.peek() : 0;
    }
}
