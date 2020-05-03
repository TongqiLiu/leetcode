package src.MaximalRectangle;

import java.util.Stack;

/**
 * @author mingqiao
 * @Date 2019/12/31
 */
public class MaximalRectangle {

    /**
     * 从第一行往下看，每行便是在求LargestRectangleinHistogram里的最大矩阵面积了，复杂度O(N * M)
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int ans = 0;
        int[] heights = new int[matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            //遍历每一列，更新高度
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1') {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
            }
            //调用上一题的解法，更新函数
            ans = Math.max(ans, largestRectangleArea(heights));
        }
        return ans;
    }

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
