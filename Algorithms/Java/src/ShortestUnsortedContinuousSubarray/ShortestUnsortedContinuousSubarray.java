package src.ShortestUnsortedContinuousSubarray;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * @author mingqiao
 * @Date 2020/2/1
 */
public class ShortestUnsortedContinuousSubarray {

    /**
     * 可以使用单调栈正着找到乱序最左边界， 同时反着找到乱序最右边界，复杂度O(n)
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int l = nums.length, r = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                r = Math.max(r, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();

        return r - l > 0 ? r - l + 1 : 0;
    }

    /**
     * 扫一遍也能获取这两个想要的位置
     * @param nums
     * @return
     */
    public int findUnsortedSubarray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int max = nums[0], min = nums[len - 1];
        int l = nums.length - 1, r = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] < max) {
                r = i;
            } else {
                max = nums[i];
            }

            if (nums[len - 1 - i] > min) {
                l = len - 1 - i;
            } else {
                min = nums[len - 1 - i];
            }
        }
        return r - l > 0 ? r - l + 1 : 0;
    }
}
