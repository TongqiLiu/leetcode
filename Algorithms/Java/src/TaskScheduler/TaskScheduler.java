package src.TaskScheduler;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/1/25
 */
public class TaskScheduler {

    /**
     * 贪心原则，数量最大的元素一定能占据(maxSize - 1) * (n + 1) + 1这段循环节，
     * 后续再看仍有多少相同数量元素未排进去的，注意ABCABCABCDF这种最大元素全排完仍未排满，
     * 故这种需要和字符串长度比较下
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length <= 1 || n < 1) {
            return tasks.length;
        }

        int[] count = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
        }
        Arrays.sort(count);
        int maxSize = count[25];
        int maxCount = (maxSize - 1) * (n + 1) + 1;

        for (int i = 0; i < 25; i++) {
            if (count[i] == maxSize) {
                maxCount++;
            }
        }
        return Math.max(maxCount, tasks.length);
    }
}
