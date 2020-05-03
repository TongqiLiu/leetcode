package src.MovingAverageFromDataStream;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mingqiao
 * @Date 2020/3/9
 */
public class MovingAverage {

    private int size = 0;
    private double sum = 0.0;
    private Queue<Integer> queue = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        sum += val;
        queue.offer(val);
        if (queue.size() > this.size) {
            sum -= queue.poll();
        }
        return sum / queue.size();
    }
}
