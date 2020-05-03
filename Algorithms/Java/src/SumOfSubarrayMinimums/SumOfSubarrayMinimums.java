package src.SumOfSubarrayMinimums;

import java.util.Stack;

/**
 * @author mingqiao
 * @Date 2020/3/22
 */
public class SumOfSubarrayMinimums {

    /**
     * 维护一个单调递增栈，每次遇到比栈顶小的数则出栈并计算它所能"管控"的范围长度，复杂度O(N)
     *
     * @param A
     * @return
     */
    public int sumSubarrayMins(int[] A) {
        Stack<Integer> stack = new Stack<>();
        long res = 0, mod = 1000000007;
        for (int i = 0; i < A.length; i++) {
            //栈顶元素大于当前元素则出栈
            while (!stack.empty() && A[stack.peek()] >= A[i]) {
                int index = stack.pop();
                int lastindex = stack.empty() ? -1 : stack.peek();
                //left-i左区间及i-right右区间
                res += (long)(index - lastindex) * (i - index) * A[index] % mod;
                res %= mod;
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            int index = stack.pop();
            int lastindex = stack.empty() ? -1 : stack.peek();
            res += (long)(index - lastindex) * (A.length - index) * A[index] % mod;
            res %= mod;
        }
        return (int)res;
    }
}
