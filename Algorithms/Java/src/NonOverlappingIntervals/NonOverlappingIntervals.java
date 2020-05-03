package src.NonOverlappingIntervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mingqiao
 * @Date 2020/2/4
 */
public class NonOverlappingIntervals {

    /**
     * 贪心，右边界排序计算多少重叠的线段
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int ans = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                ans++;
            } else {
                end = intervals[i][1];
            }
        }
        return ans;
    }
}
