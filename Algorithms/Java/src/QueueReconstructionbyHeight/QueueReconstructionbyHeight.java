package src.QueueReconstructionbyHeight;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author mingqiao
 * @Date 2020/2/15
 */
public class QueueReconstructionbyHeight {

    /**
     * 先按高度h倒排，再看个数k正排，然后根据元素的k插到k位置上：
     * 贪心策略，遍历时矮个子后处理使其插到k位置时保证前面已经有k个高个子了
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
