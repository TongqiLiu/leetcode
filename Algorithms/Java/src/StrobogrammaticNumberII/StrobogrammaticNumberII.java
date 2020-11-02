package src.StrobogrammaticNumberII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/11/2
 */
public class StrobogrammaticNumberII {

    private char[][] chars = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};

    /**
     * 题目地址：https://leetcode-cn.com/problems/strobogrammatic-number-ii/
     * dfs回溯
     *
     * @param n
     * @return
     */
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<>();
        if (n < 1) {
            return ans;
        }
        if (n == 1) {
            return Arrays.asList("0", "1", "8");
        }

        char[] res = new char[n];
        dfs(res, 0, n - 1, ans);
        return ans;
    }

    public void dfs(char[] res, int l, int r, List<String> ans) {
        if (l > r) {
            if (res[0] != '0') {
                ans.add(new String(res));
            }
            return;
        }

        for (char[] map : chars) {
            //奇数位的话只能放0，1，8
            if (l == r && map[0] != map[1]) {
                continue;
            }

            res[l] = map[0];
            res[r] = map[1];
            dfs(res, l + 1, r - 1, ans);
        }
    }
}
