package src.MeetingRoomsII;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author mingqiao
 * @Date 2020/2/4
 */
public class MeetingRoomsII {

    /**
     * 依然是两端点排序，模拟计算有多少重叠的区间
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int ans = 0;
        for (int i = 0, j = 0; i < n; i++) {
            if (starts[i] < ends[j]) {
                ans++;
            } else {
                j++;
            }
        }
        return ans;
    }
}
