package src.CourseScheduleIII;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author mingqiao
 * @Date 2020/3/20
 */
public class CourseScheduleIII {

    /**
     * 贪心策略：
     * 1.按照结束时间对课程进行排序
     * 2.使用一个大顶堆来储存已经选择的课程的长度
     * 3.如果遍历到当前课程时，其结束时间超过了deadline，那么就从已经安排的课程中取消掉一门最耗时的课程
     *
     * @param courses
     * @return
     */
    public int scheduleCourse(int[][] courses) {
        if (courses == null || courses.length == 0) {
            return 0;
        }

        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;

        for (int[] course : courses) {
            int ct = course[0];
            int cd = course[1];

            if (time + ct <= cd) {
                queue.offer(ct);
                time += ct;
            } else if (!queue.isEmpty() && queue.peek() > ct) {
                //替换掉最耗时的那门课
                time += ct - queue.poll();
                queue.offer(ct);
            }
        }
        return queue.size();
    }
}
