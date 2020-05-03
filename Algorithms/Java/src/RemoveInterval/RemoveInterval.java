package src.RemoveInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/2/29
 */
public class RemoveInterval {

    /**
     * 分类讨论删除情况
     *
     * @param intervals
     * @param toBeRemoved
     * @return
     */
    public static List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> ans = new ArrayList<>();
        int toBeStart = toBeRemoved[0], toBeEnd = toBeRemoved[1];

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            //无交集则保留
            if (end <= toBeStart || toBeEnd <= start) {
                ans.add(Arrays.asList(start, end));
                continue;
            }
            //完全被删除则忽略
            if (toBeStart <= start && end <= toBeEnd) {
                continue;
            }

            //区间部分被覆盖
            int newStart = start, newEnd = end;
            if (toBeEnd < end) {
                newStart = toBeEnd;
            }
            if (start < toBeStart) {
                newEnd = toBeStart;
            }

            if (newStart < newEnd) {
                //删除区间非本线段子集情况
                ans.add(Arrays.asList(newStart, newEnd));
            } else if (newEnd < newStart) {
                //删除区间为本线段子集，故切割成两个新线段
                ans.add(Arrays.asList(start, newEnd));
                ans.add(Arrays.asList(newStart, end));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        removeInterval(new int[][] {{0, 5}}, new int[] {2, 3});
    }
}
