package src.JumpGame;

/**
 * @author mingqiao
 * @Date 2019/12/29
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int maxPos = 0, ans = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                ans++;
                end = Math.min(maxPos, nums.length - 1);
            }
        }
        if (end < nums.length - 1) {
            return false;
        }
        return true;
    }
}
