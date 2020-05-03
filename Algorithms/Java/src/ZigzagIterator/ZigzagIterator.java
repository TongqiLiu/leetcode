package src.ZigzagIterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mingqiao
 * @Date 2020/3/5
 */
public class ZigzagIterator {

    private Queue<Iterator<Integer>> queue = new LinkedList<>();

    /**
     * 使用迭代器
     *
     * @param v1
     * @param v2
     */
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        Iterator<Integer> it1 = v1.iterator();
        Iterator<Integer> it2 = v2.iterator();
        if (it1.hasNext()) {
            queue.add(it1);
        }
        if (it2.hasNext()) {
            queue.add(it2);
        }
    }

    public int next() {
        Iterator<Integer> it = queue.poll();
        int v = it.next();
        if (it.hasNext()) {
            queue.add(it);
        }
        return v;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
