package src.RemoveDuplicateLetters;

import java.util.Stack;

/**
 * @author mingqiao
 * @Date 2020/10/15
 */
public class RemoveDuplicateLetters {

    /**
     * 题目地址：https://leetcode-cn.com/problems/remove-duplicate-letters/
     * 单调栈，复杂度O(N)，难点在于需要分析到栈顶元素之后不再出现时则不能再出栈
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();

        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        boolean[] vis = new boolean[26];
        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            cnt[index]--;
            if (vis[index]) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > ch) {
                //如果之后不会再出现这个栈顶元素则不能再出栈
                if (cnt[stack.peek() - 'a'] == 0) {
                    break;
                }
                vis[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            vis[index] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
