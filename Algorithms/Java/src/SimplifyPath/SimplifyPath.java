package src.SimplifyPath;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author mingqiao
 * @Date 2020/1/7
 */
public class SimplifyPath {

    /**
     * 按题意模拟栈
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String[] str = path.split("/");
        System.out.println(Arrays.toString(str));
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            if (!stack.isEmpty() && str[i].equals("..")) {
                stack.pop();
            } else if(!str[i].equals("") && !str[i].equals(".") && !str[i].equals("..")) {
                stack.push(str[i]);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        String ans = stack.stream().collect(Collectors.joining("/"));
        return "/" + ans;
    }
}
