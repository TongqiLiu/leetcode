package src.PatchingArray;

/**
 * @author mingqiao
 * @Date 2020/3/5
 */
public class PatchingArray {

    /**
     * 定义miss为最小缺失的数，那么假设我们添加的数字是x，则区间[1, miss)和[x, x + miss)均被覆盖到，且
     * x <= miss，这两个区间必然覆盖了区间[1, x + miss)，故贪心原则肯定要覆盖面更大点即此时x=miss刚好
     *
     * @param nums
     * @param n
     * @return
     */
    public static int minPatches(int[] nums, int n) {
        int ans = 0, i = 0;
        long miss = 1;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                miss += miss;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        minPatches(new int[] {4}, 5);
    }
}
