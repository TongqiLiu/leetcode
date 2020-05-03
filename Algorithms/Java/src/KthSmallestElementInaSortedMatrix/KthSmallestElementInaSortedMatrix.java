package src.KthSmallestElementInaSortedMatrix;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author mingqiao
 * @Date 2020/2/15
 */
public class KthSmallestElementInaSortedMatrix {

    /**
     * 这里使用优先队列法，也可以使用二分法对数组进行放缩
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix[0].length == 0) {
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int value = matrix[i][j];
                queue.offer(value);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        return queue.peek();
    }
}
