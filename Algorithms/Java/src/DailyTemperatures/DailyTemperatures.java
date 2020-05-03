package src.DailyTemperatures;

import java.util.Stack;

/**
 * @author mingqiao
 * @Date 2020/1/25
 */
public class DailyTemperatures {

    /**
     * 单调栈，相当于找每个元素右边第一个大于它的数，复杂度O(N)
     */
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return null;
        }

        int n = T.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int index = 0; index < n; index++) {
            if (stack.isEmpty()) {
                stack.push(index);
            } else {
                while (!stack.isEmpty() && T[stack.peek()] < T[index]) {
                    Integer topIndex = stack.pop();
                    ans[topIndex] = index - topIndex;
                }
                stack.push(index);
            }
        }

        while (!stack.empty()) {
            Integer topIndex = stack.pop();
            ans[topIndex] = 0;
        }
        return ans;
    }
}
