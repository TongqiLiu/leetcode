package src.KClosestPointsToOrigin;

import java.util.PriorityQueue;

/**
 * @author mingqiao
 * @Date 2020/3/27
 */
public class KClosestPointsToOrigin {

    /**
     * 维护小顶堆，复杂度O(N * logN)
     *
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            long dis1 = (long)o1[0] * o1[0] + (long)o1[1] * o1[1];
            long dis2 = (long)o2[0] * o2[0] + (long)o2[1] * o2[1];
            return (int)(dis1 - dis2);
        });
        for (int[] point : points) {
            priorityQueue.offer(point);
        }
        int[][] result = new int[K][];
        for (int i = 0; i < K; i++) {
            result[i] = priorityQueue.poll();
        }
        return result;
    }
}
