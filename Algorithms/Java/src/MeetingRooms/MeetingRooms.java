package src.MeetingRooms;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/2/4
 */
public class MeetingRooms {

    /**
     * 双断点排下序
     * @param intervals
     * @return
     */
    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int i = 0, j = 0; i < n; i++) {
            if (i != n - 1 && starts[i + 1] < ends[i]) {
                return false;
            }
        }
        return true;
    }
}
