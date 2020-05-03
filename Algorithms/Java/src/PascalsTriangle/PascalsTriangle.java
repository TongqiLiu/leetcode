package src.PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/2/10
 */
public class PascalsTriangle {

    /**
     * 递归模拟下转移方程
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        if (numRows == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            res.add(list);
            return res;
        }

        res = generate(numRows - 1);
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for (int j = 1; j < numRows - 1; j++) {
            cur.add(res.get(numRows - 2).get(j - 1) + res.get(numRows - 2).get(j));
        }
        cur.add(1);
        res.add(cur);
        return res;
    }
}
