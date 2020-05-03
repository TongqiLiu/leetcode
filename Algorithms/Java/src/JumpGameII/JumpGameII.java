package src.JumpGameII;

/**
 * @author mingqiao
 * @Date 2019/12/18
 */
public class JumpGameII {

    /**
     * 暴力dp会超时，贪心即可，位置从1->4可以视为1->2->3->4的变种，故只需要看看1->4中最远能达
     * 边界在哪，遇到时再计数
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int ans = 0;
        int maxPos = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                ans++;
                end = Math.min(maxPos, nums.length - 1);
            }
        }
        return ans - 1;
    }
}
