package src.GetKthMagicNumberLCCI;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author mingqiao
 * @Date 2020/8/23
 */
public class GetKthMagicNumberLCCI {

    /**
     * 题目地址：https://leetcode-cn.com/problems/get-kth-magic-number-lcci/
     * 记录三个指针不断往前迭代，复杂度O(N)
     *
     * @param k
     * @return
     */
    public int getKthMagicNumber(int k) {
        int p3 = 0, p5 = 0, p7 = 0;

        int[] dp = new int[k];
        dp[0] = 1;
        for (int i = 1; i < k; i++) {
            dp[i] = Math.min(Math.min(dp[p3] * 3, dp[p5] * 5), dp[p7] * 7);
            if (dp[i] == dp[p3] * 3) { p3++; }
            if (dp[i] == dp[p5] * 5) { p5++; }
            if (dp[i] == dp[p7] * 7) { p7++; }
        }
        return dp[k - 1];
    }

    /**
     * 小顶堆模拟，复杂度O(N * logN)
     *
     * @param k
     * @return
     */
    public int getKthMagicNumber1(int k) {
        Set<Long> set = new HashSet<>();
        Queue<Long> queue = new PriorityQueue<>();
        queue.add(1L);

        while (true) {
            Long num = queue.poll();
            if (!set.contains(num)) {
                set.add(num);
                queue.add(num * 3);
                queue.add(num * 5);
                queue.add(num * 7);
            }
            if (set.size() == k) {
                return num.intValue();
            }
        }
    }
}
