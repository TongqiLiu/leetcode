package src.SlidingWindowMaximum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author mingqiao
 * @Date 2020/2/5
 */
public class SlidingWindowMaximum {

    /**
     * 可以用大顶堆来解，复杂度O(N * logk)
     * 这里使用单调队列，复杂度O(N)
     * 维护一个长度为k的递增队列，新入一个元素v后：
     * 1.队列前面比v小的全部移除
     * 2.前面比v大的比较其下标，如果已不在窗口内同样移除
     * 这样的话保证了当队列已满开始滑动后，每次元素加入后队首元素都是最大的可以直接取出
     *
     * @param num
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] num, int k) {
        if (num == null || num.length == 0 || k <= 0 || num.length < k) {
            return new int[] {};
        }
        int[] res = new int[num.length - k + 1];

        //单调递增的队列
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && num[queue.peekLast()] <= num[i]) {
                queue.pollLast();
            }

            queue.addLast(i);
            if (queue.peekFirst() + k == i) {
                queue.pollFirst();
            }
            if (i >= k - 1) {
                //System.out.println("i - k + 1:" + (i - k + 1));
                res[i - k + 1] = num[queue.peekFirst()];
            }
        }
        return res;
    }

    /**
     * 大顶堆实现，复杂度O(N * logK)
     *
     * @param num
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] num, int k) {
        if (num == null || num.length == 0 || k <= 0 || num.length < k) {
            return new int[] {};
        }
        int[] res = new int[num.length - k + 1];

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < num.length; i++) {
            if (queue.size() == k) {
                queue.remove(num[i - k]);
            }
            queue.add(num[i]);
            if (i >= k - 1) {
                res[i - k + 1] = queue.peek();
            }
        }
        return res;
    }
}
