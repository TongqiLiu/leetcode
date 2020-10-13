package src.RemoveBoxes;

/**
 * @author mingqiao
 * @Date 2020/10/13
 */
public class RemoveBoxes {

    /**
     * 题目地址：https://leetcode-cn.com/problems/remove-boxes/
     * 本题爆搜会超时，故需要使用记忆化搜索解决，对于box例如[6,3,6,5,6,7,6,6,8,6]有两种合并方案：
     * 1.消除最右边的6，计算左边部分
     * 2.干掉影响6合并的8，计算其余部分
     * dp[l][r][k]表示[l,r]区间之后连着和r相等的k个元素所获得的最大值，时间复杂度O(N ^ 4)
     *
     * @param boxes
     * @return
     */
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return dfs(boxes, dp, 0, boxes.length - 1, 0);
    }

    public int dfs(int[] boxes, int[][][] dp, int l, int r, int k) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r][k] != 0) {
            return dp[l][r][k];
        }
        while (r > l && boxes[r] == boxes[r - 1]) {
            r--;
            k++;
        }

        //1方案：计算把右边k+1个相同元素消掉的得分
        dp[l][r][k] = dfs(boxes, dp, l, r - 1, 0) + (k + 1) * (k + 1);

        //2方案：从右边界向左寻找跟外部k个元素相等的元素，如果能找到则剔除中间一段不等的连到后面，再计算得分
        for (int i = r - 1; i >= l; i--) {
            if (boxes[i] == boxes[r]) {
                dp[l][r][k] = Math.max(dp[l][r][k],
                    dfs(boxes, dp, l, i, k + 1) + dfs(boxes, dp, i + 1, r - 1, 0));
            }
        }
        return dp[l][r][k];
    }
}
