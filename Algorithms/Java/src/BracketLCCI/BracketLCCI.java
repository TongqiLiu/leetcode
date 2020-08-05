package src.BracketLCCI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mingqiao
 * @Date 2020/8/4
 */
public class BracketLCCI {

    private Set<String> ans = new HashSet<>();

    private void dfs(int index, StringBuilder path, int num, int n) {
        if (num < 0) {
            return;
        }
        if (index == n * 2) {
            if (num == 0 && !ans.contains(path.toString())) {
                ans.add(path.toString());
            }
            return;
        }

        dfs(index + 1, path.append('('), num + 1, n);
        path.deleteCharAt(path.length() - 1);
        dfs(index + 1, path.append(')'), num - 1, n);
        path.deleteCharAt(path.length() - 1);
    }

    public List<String> generateParenthesis(int n) {
        ans.clear();
        dfs(0, new StringBuilder(), 0, n);
        return new ArrayList<>(ans);
    }
}
