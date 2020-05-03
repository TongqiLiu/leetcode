package src.FindMedianFromDataStream;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author mingqiao
 * @Date 2020/2/25
 */
public class FindMedianFromDataStream {

    /**
     * 维护一个大顶堆，一个小顶堆且保证两个堆数目差<=1，且小顶堆元素值均>=大顶堆元素
     * 这样获取中位数时便要么在小顶堆顶部or两堆顶部元素平均
     * 这样复杂度约为O(logN)
     */
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    /**
     * initialize your data structure here.
     */
    public FindMedianFromDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());

        if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.peek());
            maxHeap.poll();
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
}
