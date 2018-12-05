package src.ValidParentheses;

import java.util.Stack;

/**
 * author: mingqiao
 * Date: 2018/12/5
 */
//题解：经典题了，括号匹配，用栈实现括号先进后出就行
public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }

                char top = (char)stack.peek();
                stack.pop();
                switch (top) {
                    case '(': {
                        if (c != ')') {
                            return false;
                        }
                        break;
                    }
                    case '{': {
                        if (c != '}') {
                            return false;
                        }
                        break;
                    }
                    case '[': {
                        if (c != ']') {
                            return false;
                        }
                        break;
                    }
                    default:
                        break;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{{}}()([]){]"));
    }
}
