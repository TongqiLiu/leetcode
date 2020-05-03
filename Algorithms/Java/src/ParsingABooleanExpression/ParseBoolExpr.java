package src.ParsingABooleanExpression;

import java.util.Stack;

/**
 * @author mingqiao
 * @Date 2020/4/13
 */
public class ParseBoolExpr {

    /**
     * 题目地址：https://leetcode-cn.com/problems/parsing-a-boolean-expression/
     * 用栈来记录括号内的一系列字符
     *
     * @param expression
     * @return
     */
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == ')') {
                while (stack.peek() != '(') {
                    tmp.append(stack.pop());
                }
                stack.pop();

                char op = stack.pop();
                stack.push(pending(tmp.toString(), op));
                tmp = new StringBuilder();
            } else if (c != ',') {
                stack.push(c);
            }
        }
        if (stack.peek() == 't') {
            return true;
        }
        return false;
    }

    private char pending(String s, char op) {
        if (op == '!') {
            if (s.equals("f")) {
                return 't';
            } else {
                return 'f';
            }
        } else if (op == '|') {
            if (s.indexOf('t') != -1) {
                return 't';
            } else {
                return 'f';
            }
        } else if (op == '&') {
            if (s.indexOf('f') != -1) {
                return 'f';
            } else {
                return 't';
            }
        }
        return 'f';
    }
}
