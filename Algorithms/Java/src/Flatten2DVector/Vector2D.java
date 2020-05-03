package src.Flatten2DVector;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mingqiao
 * @Date 2020/3/23
 */
public class Vector2D {

    private Deque<Integer> queue = new LinkedList<>();

    public Vector2D(int[][] v) {
        for (int[] row : v) {
            for (int col : row) {
                this.queue.add(col);
            }
        }
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
