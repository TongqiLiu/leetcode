package src.BasicCalculator;

import java.util.Stack;

/**
 * @author mingqiao
 * @Date 2020/3/17
 */
public class BasicCalculator {

    /**
     * 用栈来保存之前计算的数值及加减符号
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> flagStack = new Stack<>();
        int flag = 1, res = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int tmp = s.charAt(i) - '0';
                //注意下这里的顺序避免跳过字符
                while (i + 1 < length && Character.isDigit(s.charAt(i + 1))) {
                    tmp = tmp * 10 + s.charAt(++i) - '0';
                }
                res += flag * tmp;
            } else if (ch == '+') {
                flag = 1;
            } else if (ch == '-') {
                flag = -1;
            } else if (ch == '(') {
                stack.push(res);
                res = 0;

                flagStack.push(flag);
                flag = 1;
            } else if (ch == ')') {
                res = flagStack.pop() * res + stack.pop();
            }
        }
        return res;
    }
}
