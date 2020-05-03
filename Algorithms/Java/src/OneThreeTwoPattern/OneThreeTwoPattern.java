package src.OneThreeTwoPattern;

import java.util.Stack;

/**
 * @author mingqiao
 * @Date 2020/3/19
 */
public class OneThreeTwoPattern {

    /**
     * 地址：https://leetcode-cn.com/problems/132-pattern/
     * 正向维护从左向右的最小值下标数组，同时反向维护单调递减栈，复杂度O(N)
     *
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int n = nums.length;
        int[] min = new int[n];
        Stack<Integer> stack = new Stack<>();
        min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }

        for (int j = n - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j]) {
                    stack.pop();
                }
                //比栈顶元素大则证明找到了结果
                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }
                stack.push(nums[j]);
            }
        }
        return false;
    }
}
