package src.MaxChunksToMakeSorted;

import java.util.Stack;

/**
 * @author mingqiao
 * @Date 2020/10/29
 */
public class MaxChunksToMakeSorted {

    /**
     * 题目地址：https://leetcode-cn.com/problems/max-chunks-to-make-sorted/submissions/
     * 升序单调栈维护分区间段最大值，复杂度O(N)
     *
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            if (stack.isEmpty() || stack.peek() < num) {
                stack.push(num);
            } else {
                Integer temp = stack.pop();
                while (!stack.isEmpty() && stack.peek() > num) {
                    stack.pop();
                }
                stack.push(temp);
            }
        }
        return stack.size();
    }

    /**
     * 当遍历到第i个位置时，如果可以切分为区块那前i个位置的最大值一定等于i，否则一定有比i小的数划分到后面的块
     *
     * @param arr
     * @return
     */
    public int maxChunksToSorted1(int[] arr) {
        int res = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                res++;
            }
        }
        return res;
    }
}
