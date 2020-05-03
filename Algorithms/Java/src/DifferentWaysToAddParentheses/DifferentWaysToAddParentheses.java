package src.DifferentWaysToAddParentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mingqiao
 * @Date 2020/3/27
 */
public class DifferentWaysToAddParentheses {

    private Map<String, List<Integer>> map = new HashMap<>();

    /**
     * 地址：https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
     * 分治递归计算，使用记忆化搜索加速重复子串的处理，复杂度O(N * logN)
     *
     * @param input
     * @return
     */
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return result;
        }
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            result.add(Integer.valueOf(input));
            return result;
        }
        if (map.containsKey(input)) {
            return map.get(input);
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                List<Integer> leftWays = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightWays = diffWaysToCompute(input.substring(i + 1));

                for (Integer left : leftWays) {
                    for (Integer right : rightWays) {
                        if (input.charAt(i) == '+') {
                            result.add(left + right);
                        } else if (input.charAt(i) == '-') {
                            result.add(left - right);
                        } else if (input.charAt(i) == '*') {
                            result.add(left * right);
                        }
                    }
                }
            }
        }

        map.put(input, result);
        return result;
    }
}
