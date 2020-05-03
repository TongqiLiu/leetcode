package src.FindContinuousSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mingqiao
 * @Date 2020/3/8
 */
public class FindContinuousSequence {

    /**
     * 双指针滑动窗口，当前和sum < target时，r右移；sum > target时，l左移
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();

        for (int l = 1, r = 1, sum = 0; r < target; r++) {
            sum += r;
            while (sum > target) {
                sum -= l++;
            }
            if (sum == target) {
                int[] path = new int[r - l + 1];
                for (int i = 0; i < path.length; i++) {
                    path[i] = l + i;
                }
                list.add(path);
            }
        }

        return list.toArray(new int[0][]);
    }
}
