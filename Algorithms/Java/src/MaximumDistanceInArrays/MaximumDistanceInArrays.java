package src.MaximumDistanceInArrays;

import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/10/19
 */
public class MaximumDistanceInArrays {

    /**
     * 题目地址：https://leetcode-cn.com/problems/maximum-distance-in-arrays/
     * 维护至当前位置为止的最大最小值，复杂度O(N)
     *
     * @param arrays
     * @return
     */
    public int maxDistance(List<List<Integer>> arrays) {
        int res = 0, min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size() - 1);
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            res = Math.max(res, Math.max(Math.abs(max - array.get(0)), Math.abs(array.get(array.size() - 1) - min)));
            max = Math.max(max, array.get(array.size() - 1));
            min = Math.min(min, array.get(0));
        }
        return res;
    }
}
