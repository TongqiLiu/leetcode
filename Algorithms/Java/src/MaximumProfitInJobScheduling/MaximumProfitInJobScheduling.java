package src.MaximumProfitInJobScheduling;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mingqiao
 * @Date 2020/8/31
 */
public class MaximumProfitInJobScheduling {

    private class jobs {
        int start;
        int end;
        int value;

        public jobs(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }

    /**
     * 朴素的DP转移方程，复杂度O(N ^ 2)，二分优化后O(N * LogN)
     *
     * @param startTime
     * @param endTime
     * @param profit
     * @return
     */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int dp[] = new int[n + 1];
        jobs[] job = new jobs[n];
        for (int i = 0; i < n; i++) {
            job[i] = new jobs(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(job, Comparator.comparingInt(o -> o.end));
        for (int i = 0; i < n; i++) {
            dp[i] = job[i].value;
        }
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], job[i].value);

            int index = search(job, 0, i - 1, job[i].start);
            // int index = i - 1 O(N ^ 2)
            for (int j = index; j >= 0; j--) {
                if (job[j].end <= job[i].start) {
                    dp[i] = Math.max(dp[i], dp[j] + job[i].value);
                    break;
                }
            }
        }
        return dp[n - 1];
    }

    /**
     * 二分找到>target的数，找不到则整个数组可用
     */
    private int search(jobs[] job, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int originR = r;
        int pos = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midVal = job[mid].end;

            if (midVal <= target) {
                l = mid + 1;
                if (midVal == target) {
                    pos = mid;
                }
            } else {
                r = mid - 1;
            }
        }
        return pos == -1 ? originR : pos;
    }

    public static void main(String[] args) {
        MaximumProfitInJobScheduling job = new MaximumProfitInJobScheduling();
        job.jobScheduling(new int[] {1, 2, 3, 3}, new int[] {3, 4, 5, 6}, new int[] {50, 10, 40, 70});
    }
}
