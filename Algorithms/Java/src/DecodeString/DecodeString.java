package src.DecodeString;

import java.util.LinkedList;

/**
 * @author mingqiao
 * @Date 2020/2/5
 */
public class DecodeString {

    /**
     * 遍历字符串中存在的4中情况：数字、字母、[、]
     * 遇到数字：累计相乘计算
     * 遇到字母：累加连续字母
     * 遇到左括号：之前累计的数字、字母入栈
     * 遇到右括号：将数字出栈，将累加字母翻倍，将字母也出栈，和累计字母拼接
     *
     * @param s
     * @return
     */
    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<String> stringStack = new LinkedList<>();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                numStack.add(num);
                stringStack.add(sb.toString());
                sb = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                String item = sb.toString();
                Integer numItem = numStack.removeLast();
                for (int i = 1; i <= numItem - 1; i++) {
                    sb.append(item);
                }
                sb.insert(0, stringStack.removeLast());
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        decodeString("3[a2[c]]");
    }
}
