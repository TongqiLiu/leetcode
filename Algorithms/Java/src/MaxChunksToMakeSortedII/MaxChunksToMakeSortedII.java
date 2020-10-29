package src.MaxChunksToMakeSortedII;

import java.util.Stack;

/**
 * @author mingqiao
 * @Date 2020/10/29
 */
public class MaxChunksToMakeSortedII {

    /**
     * 题目地址：https://leetcode-cn.com/problems/max-chunks-to-make-sorted-ii/
     * 和上题一样使用升序单调栈维护分块最大值，需要注意重复值
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
            if (stack.isEmpty() || stack.peek() <= num) {
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
}
