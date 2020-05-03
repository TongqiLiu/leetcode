package src.BasicCalculatorII;

import java.util.Stack;

/**
 * @author mingqiao
 * @Date 2020/3/17
 */
public class BasicCalculatorII {

    /**
     * 地址：https://leetcode-cn.com/problems/basic-calculator-ii/
     * 首先跳过空格，遇到数字则累加，遇到运算符则分类讨论：
     * 1."+","-"入栈和后续出栈的数一些处理
     * 2."*","/"则计算栈顶和当前数字
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();

        char lastOp = '+';
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                continue;
            }

            if (Character.isDigit(arr[i])) {
                int num = arr[i] - '0';
                while (i + 1 < arr.length && Character.isDigit(arr[i + 1])) {
                    num = num * 10 + (arr[++i] - '0');
                }
                if (lastOp == '+') {
                    numStack.push(num);
                } else if (lastOp == '-') {
                    numStack.push(-num);
                } else {
                    numStack.push(cal(lastOp, numStack.pop(), num));
                }
            } else {
                lastOp = arr[i];
            }
        }

        int ans = 0;
        for (int num : numStack) {
            ans += num;
        }
        return ans;
    }

    private int cal(char op, int a, int b) {
        if (op == '*') {
            return a * b;
        } else if (op == '/') {
            return a / b;
        } else if (op == '+') {
            return a + b;
        } else {
            return a - b;
        }
    }
}
