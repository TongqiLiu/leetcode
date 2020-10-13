package src.Triangle;

import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/10/13
 */
public class Triangle {

    /**
     * 题目地址：https://leetcode-cn.com/problems/triangle/
     * 杨辉三角，使用自底向下推法，滚动数组优化一维空间
     * 时间复杂度O(N ^ 2)，空间复杂度O(N)
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();

        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
