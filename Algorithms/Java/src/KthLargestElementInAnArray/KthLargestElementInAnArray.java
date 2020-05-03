package src.KthLargestElementInAnArray;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author mingqiao
 * @Date 2020/2/16
 */
public class KthLargestElementInAnArray {

    /**
     * 小顶堆维护k个元素，堆顶即为第k大的元素
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return -1;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
