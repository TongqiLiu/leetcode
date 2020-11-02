package src.PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/11/2
 */
public class PascalsTriangleII {

    /**
     * 题目地址：https://leetcode-cn.com/problems/pascals-triangle-ii/comments/
     * 模拟一下
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            cur = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return cur;
    }
}
