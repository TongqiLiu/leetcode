package src.RemoveInvalidParentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mingqiao
 * @Date 2020/2/18
 */
public class RemoveInvalidParentheses {

    /**
     * bfs去循环枚举删掉一个字符，二个字符...的所有可能，一旦找到结果就将队列元素循环完后跳出
     *
     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.equals("") || s.equals("()")) {
            result.add(s);
            return result;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(s);

        HashSet<String> set = new HashSet<>();
        boolean flag = false;

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (isValid(cur)) {
                result.add(cur);
                flag = true;
            }
            if (flag) {
                continue;
            }
            //枚举删除当前字符串一种所有可能性
            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) == '(' || cur.charAt(i) == ')') {
                    String str;
                    if (i == cur.length() - 1) {
                        str = cur.substring(0, cur.length() - 1);
                    } else {
                        str = cur.substring(0, i) + cur.substring(i + 1);
                    }
                    if (set.add(str)) {
                        queue.offer(str);
                    }
                }
            }
        }

        if (result.isEmpty()) {
            result.add("");
        }
        return result;
    }

    private boolean isValid(String s) {
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i);
            if (cur == '(') {
                left++;
            } else if (cur == ')') {
                if (left != 0) {
                    left--;
                } else {
                    return false;
                }
            }
        }
        return left == 0;
    }
}
