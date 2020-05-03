package src.BasicCalculatorIII;

import java.util.Stack;

/**
 * @author mingqiao
 * @Date 2020/3/18
 */
public class BasicCalculatorIII {

    /**
     * 题目地址：https://leetcode-cn.com/problems/basic-calculator-iii/
     * 通过四则运算符把结果分为两组，表示形式为：res = num1 + flag1 * num2
     * 每次遇到+-符号时将之前累计的乘除结果计算出来
     *
     * @param s
     * @return
     */
    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int num1 = 0;
        int flag1 = 1;
        int num2 = 1;
        int flag2 = 1;
        int n = s.length();
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> flagStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int tmp = arr[i] - '0';
                while (i + 1 < arr.length && Character.isDigit(arr[i + 1])) {
                    tmp = tmp * 10 + (arr[++i] - '0');
                }

                num2 = flag2 == 1 ? num2 * tmp : num2 / tmp;
            } else if (c == '*' || c == '/') {
                flag2 = c == '*' ? 1 : -1;
            } else if (c == '(') {
                stack.push(num1);
                flagStack.push(flag1);
                stack.push(num2);
                flagStack.push(flag2);

                num1 = 0;
                flag1 = 1;
                num2 = 1;
                flag2 = 1;
            } else if (c == '+' || c == '-') {
                //负数的特殊处理
                if (c == '-' && (i == 0 || s.charAt(i - 1) == '(')) {
                    flag1 = -1;
                    continue;
                }

                num1 = num1 + flag1 * num2;
                flag1 = (c == '+' ? 1 : -1);

                num2 = 1;
                flag2 = 1;
            } else if (c == ')') {
                int cur = num1 + flag1 * num2;
                flag2 = flagStack.pop();
                num2 = stack.pop();
                flag1 = flagStack.pop();
                num1 = stack.pop();

                num2 = flag2 == 1 ? num2 * cur : num2 / cur;
            }
        }
        return num1 + flag1 * num2;
    }

    public static void main(String[] args) {
        calculate("(2+6* 3+5- (3*14/7+2)*5)+3");
    }
}
