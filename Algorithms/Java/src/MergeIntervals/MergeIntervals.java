package src.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2019/12/29
 */
public class MergeIntervals {

    public static class Interval implements Comparable<Interval> {
        int start;
        int end;

        public Interval() {
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            if (this.start != o.start) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
        }
    }

    /**
     * 有个取巧的做法是首尾两数组分别排序，然后不断维护最小的左边界能撬动的最大右边界位置
     * j位置为左边界开始位置，i位置为右边界结束位置
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        List<Interval> ans = new ArrayList<>();
        for (int i = 0, j = 0; i < n; i++) {
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                ans.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }

        int[][] mergeArray = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            Interval interval = ans.get(i);
            mergeArray[i][0] = interval.start;
            mergeArray[i][1] = interval.end;
        }
        return mergeArray;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][] {{1, 4}, {0, 2}, {3, 5}};
        merge(merge(nums));
    }
}
