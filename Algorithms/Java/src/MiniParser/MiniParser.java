package src.MiniParser;

import java.util.Stack;

import src.A_Common_Package.NestedInteger;

/**
 * @author mingqiao
 * @Date 2020/10/10
 */
public class MiniParser {

    /**
     * 题目地址：https://leetcode-cn.com/problems/mini-parser/
     * 题意意为把s转化成为类似json的NestedInteger结构，这种括号嵌套的问题一般都是用栈或者递归来处理，复杂度O(N)
     *
     * @param s
     * @return
     */
    public static NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.valueOf(s));
        }

        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger res = new NestedInteger();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                NestedInteger node = new NestedInteger();
                if (!stack.isEmpty()) {
                    stack.peek().add(node);
                }
                stack.push(node);
            }
            if (c >= '0' && c <= '9' || c == '-') {
                StringBuilder num = new StringBuilder(c + "");
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    num.append(s.charAt(++i));
                }
                NestedInteger node = new NestedInteger(Integer.valueOf(num.toString()));
                if (stack.isEmpty()) {
                    stack.push(node);
                } else {
                    stack.peek().add(node);
                }
            }
            if (c == ']') {
                res = stack.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        deserialize("[123,[456,[789]]]");
    }
}
