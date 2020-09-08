package src.EmployeeFreeTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import src.MergeIntervals.MergeIntervals.Interval;

/**
 * @author mingqiao
 * @Date 2020/9/8
 */
public class EmployeeFreeTime {

    class Point implements Comparable<Point> {
        int time;
        boolean ifStart;

        Point(int time, boolean ifStart) {
            this.time = time;
            this.ifStart = ifStart;
        }

        @Override
        public int compareTo(Point that) {
            if (this.time != that.time || this.ifStart == that.ifStart) {
                return this.time - that.time;
            } else {
                return this.ifStart ? -1 : 1;
            }
        }
    }

    /**
     * 解法一：可扩展到K个员工同时空闲
     * 把所有区间拆成双端点，每次碰到左端点cnt++，右端点cnt--，当cnt<=n-k时就是一个新的区间，复杂度O(N * logN)
     *
     * @param intervals
     * @param k
     * @return
     */
    public List<Interval> getAvailableIntervals(List<List<Interval>> intervals, int k) {
        List<Interval> res = new ArrayList<>();
        List<Point> points = new ArrayList<>();

        for (List<Interval> intervalList : intervals) {
            for (Interval interval : intervalList) {
                points.add(new Point(interval.start, true));
                points.add(new Point(interval.end, false));
            }
        }
        Collections.sort(points);

        int cnt = 0;
        Integer lastStart = null;
        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);
            if (point.ifStart) {
                cnt++;
                if (i == 0 && cnt <= intervals.size() - k) {
                    lastStart = point.time;
                } else if (lastStart != null && cnt == intervals.size() - k + 1) {
                    res.add(new Interval(lastStart, point.time));
                    lastStart = null;
                }
            } else {
                cnt--;
                if (lastStart != null && i == points.size() - 1 && cnt <= intervals.size() - k) {
                    res.add(new Interval(lastStart, point.time));
                    lastStart = null;
                } else if (cnt == intervals.size() - k && i < points.size()) {
                    lastStart = point.time;
                }
            }
        }

        return res;
    }

    /**
     * 解法二：优先队列，复杂度O(N * logK)，N为区间数，K为员工数
     *
     * @param schedule
     * @return
     */
    public List<Interval> employeeFreeTime1(List<List<Interval>> schedule) {
        //按左，右端点升序排列
        PriorityQueue<Interval> queue = new PriorityQueue<>((o1, o2) -> (o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start));
        schedule.forEach(queue::addAll);

        Interval previous = queue.poll();
        List<Interval> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Interval current = queue.poll();
            //相当于区间重叠需要做区间合并
            if (previous.end >= current.start) {
                previous.end = Math.max(previous.end, current.end);
            } else {
                //本段相当于空闲
                res.add(new Interval(previous.end, current.start));
                previous = current;
            }
        }
        return res;
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        if (schedule == null || schedule.size() == 0) {
            return new ArrayList<>();
        }
        return getAvailableIntervals(schedule, schedule.size());
    }
}
