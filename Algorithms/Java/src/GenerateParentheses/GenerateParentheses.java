package src.GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * author: mingqiao
 * Date: 2018/12/5
 */
//题解：递归一下，每次有左右两种括号选择，当出现右括号个数大于左括号时就为不合法情况，时间复杂度O(2 ^ N)
public class GenerateParentheses {

    List<String> result = new ArrayList<>();

    public void dfs(String temp, int dep, int left, int right) {
        if(right > left) {
            return ;
        }
        if(left + right == dep * 2) {
            if(left == right) {
                result.add(temp);
            }
            return ;
        }

        dfs(temp + "(", dep, left + 1, right);
        dfs(temp + ")", dep, left, right + 1);
    }

    public List<String> generateParenthesis(int n) {
        String temp = "";
        dfs(temp, n, 0, 0);
        return result;
    }
}
