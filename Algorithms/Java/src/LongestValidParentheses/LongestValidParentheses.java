package src.LongestValidParentheses;

import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

/**
 * author: mingqiao
 * Date: 2019/3/26
 */
public class LongestValidParentheses {

    /**
     * 解法一：使用栈的方式记录'('出现的位置，同时维护一个start坐标记录目前可连续累加的坐标左边界，遇到')'
     * 且栈空时重置start坐标
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        if (s.isEmpty() || s.length() == 0) {
            return 0;
        }
        int ans = 0, start = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        ans = Math.max(ans, i - start + 1);
                    } else {
                        ans = Math.max(ans, i - stack.peek() + 1);
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 解法二：dp[i]表示以该i结尾的最大匹配长度且'('时不转移，如果s[i - 1 - dp[i - 1]]位置为'('，说明可以和当前位置匹配，
     * 转移方程为dp[i] = dp[i - 1] + 2，同时加上该对括号之前能匹配到的最大程度即dp[i] += dp[i - dp[i]]
     * @param s
     * @return
     */
    public static int longestValidParentheses1(String s) {
        if (s.isEmpty() || s.length() == 0) {
            return 0;
        }
        int ans = 0;
        int dp[] = new int[s.length() + 1];
        Arrays.fill(dp, 0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                    dp[i] += dp[i - 1] + 2;
                }
                if(i - dp[i] > 0) {
                    dp[i] += dp[i - dp[i]];
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()()())()()()()"));
    }
}
