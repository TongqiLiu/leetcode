package src.TwoFourGame;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/10/27
 */
public class TwoFourGame {

    /**
     * 题目地址：https://leetcode-cn.com/problems/24-game/
     * dfs递归处理
     *
     * @param nums
     * @return
     */
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double)num);
        }
        return dfs(list);
    }

    private boolean dfs(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) <= 1e-6;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                List<Double> tmp = new ArrayList<>(nums);
                double b = tmp.remove(j), a = tmp.remove(i);
                boolean flag = false;
                tmp.add(a + b);

                flag |= dfs(tmp);
                tmp.set(tmp.size() - 1, a - b);
                flag |= dfs(tmp);
                tmp.set(tmp.size() - 1, a * b);
                flag |= dfs(tmp);
                tmp.set(tmp.size() - 1, a / b);
                flag |= dfs(tmp);
                tmp.set(tmp.size() - 1, b - a);
                flag |= dfs(tmp);
                tmp.set(tmp.size() - 1, b / a);
                flag |= dfs(tmp);

                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }
}
