package src.NestedListWeightSum;

import java.util.List;

import src.A_Common_Package.NestedInteger;

/**
 * @author mingqiao
 * @Date 2020/2/17
 */
public class NestedListWeightSum {

    /**
     * 记录深度递归着找
     *
     * @param nestedList
     * @return
     */
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    public int dfs(List<NestedInteger> nestedList, int point) {
        int res = 0;
        for (NestedInteger it : nestedList) {
            if (it.isInteger()) {
                res += it.getInteger() * point;
            } else {
                res += dfs(it.getList(), point + 1);
            }
        }
        return res;
    }
}
