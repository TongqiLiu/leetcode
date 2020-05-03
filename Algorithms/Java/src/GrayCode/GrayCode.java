package src.GrayCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/3/8
 */
public class GrayCode {

    /**
     * 题目地址：https://leetcode-cn.com/problems/gray-code/
     * 观察知n=3时，结果集为{000, 010, 011, 001, 101, 111, 110, 100}，也就是n=2的结果集基础上
     * 将其顺序倒置并在最高位补上(1<<2)的数字
     * 这里同时可以使用公式：(binary ^ binary >> 1)
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        for (int i = 0; i < n; i++) {
            //高位新增的数字
            int add = 1 << i;
            for (int j = ans.size() - 1; j >= 0; j--) {
                ans.add(ans.get(j) + add);
            }
        }
        return ans;
    }
}
