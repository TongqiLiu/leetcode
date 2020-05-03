package src.LargestRectangleinHistogram;

import java.util.Stack;

/**
 * @author mingqiao
 * @Date 2019/12/31
 */
public class LargestRectangleinHistogram {

    /**
     * 维护一个递增的单调栈，复杂度O(N)，有两个trick：
     * 1.数组尾部放入一个负数，这样保证最后栈一定能空不需要单独再拿出来算一遍
     * 2.[2,1,2]这种假如遇到中间的1，那么出栈时把栈顶延长至最左端的节点，因为此时矩形面积是可延展的
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int[] heightList = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            heightList[i] = heights[i];
        }
        heightList[heights.length] = -1;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heightList.length; i++) {
            if (stack.empty() || heightList[stack.peek()] < heightList[i]) {
                stack.push(i);
            } else {
                int leftIndex = -1;
                while (!stack.empty() && heightList[stack.peek()] >= heightList[i]) {
                    leftIndex = stack.pop();
                    ans = Math.max(ans, Math.max((i - leftIndex + 1) * heightList[i], (i - leftIndex) * heightList[leftIndex]));
                }
                if (leftIndex != -1) {
                    stack.push(leftIndex);
                    heightList[leftIndex] = heightList[i];
                }
            }
        }
        return ans;
    }
}
