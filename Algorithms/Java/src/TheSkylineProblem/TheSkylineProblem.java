package src.TheSkylineProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

import javafx.util.Pair;

/**
 * @author mingqiao
 * @Date 2020/3/3
 */
public class TheSkylineProblem {

    /**
     * 扫描线法，先将矩形按(x,y)来排，然后扫描如果遇到左端点则放入大顶堆，遇到右端点则将该高度从堆中删除，并不断记录上一个转折点
     *
     * @param buildings
     * @return
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Pair<Integer, Integer>> pairs = new TreeSet<>((o1, o2) ->
            !o1.getKey().equals(o2.getKey()) ? o1.getKey() - o2.getKey() : o1.getValue() - o2.getValue());
        for (int[] build : buildings) {
            pairs.add(new Pair<>(build[0], -build[2]));
            pairs.add(new Pair<>(build[1], build[2]));
        }
        // 优先队列的最大堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // 记录之前的高度
        int pre = 0;
        for (Pair<Integer, Integer> pair : pairs) {
            if (pair.getValue() < 0) {
                //左端点高度入堆
                queue.offer(-pair.getValue());
            } else {
                //右端点高度出堆
                queue.remove(pair.getValue());
            }
            //获取最大堆的当前顶点，当null时置为0，如果最大高度不同于上一个高度证明到了拐点
            Integer cur = queue.peek() == null ? 0 : queue.peek();
            if (pre != cur) {
                res.add(new ArrayList<Integer>() {{
                    add(pair.getKey());
                    add(cur);
                }});
                pre = cur;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        queue.offer(3);
        queue.offer(4);
        queue.offer(4);
        System.out.println(queue.peek());
    }
}
