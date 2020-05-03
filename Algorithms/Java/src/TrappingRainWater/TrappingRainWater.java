package src.TrappingRainWater;

import java.util.Stack;

/**
 * @author mingqiao
 * @Date 2019/12/3
 */
public class TrappingRainWater {

    /**
     * 左右各扫一遍，不断累加两个高点间的容积，注意右边重来时不要算重
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int max = 0, maxPos = 0, ans = 0, subCount = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= max) {
                ans += max * (i - maxPos - 1) - subCount;
                max = height[i];
                maxPos = i;
                subCount = 0;
            } else {
                subCount += height[i];
            }
        }

        subCount = 0;
        max = 0;
        maxPos = height.length - 1;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > max) {
                ans += max * (maxPos - i - 1) - subCount;
                max = height[i];
                maxPos = i;
                subCount = 0;
            } else {
                subCount += height[i];
            }
        }
        return ans;
    }

    /**
     * 用栈去做，维护高度下降的节点，当遇到比栈顶元素高的节点时再出栈并累加
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                Integer top = stack.pop();
                if (stack.empty()) {
                    break;
                }
                int distance = i - stack.peek() - 1;
                int bounded_height = Math.min(height[i], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(i);
        }
        return ans;
    }
}
