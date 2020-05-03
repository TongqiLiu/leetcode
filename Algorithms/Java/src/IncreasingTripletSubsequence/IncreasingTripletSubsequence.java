package src.IncreasingTripletSubsequence;

/**
 * @author mingqiao
 * @Date 2020/3/16
 */
public class IncreasingTripletSubsequence {

    /**
     * 维护最小值及次大值，如果有比次小值大的元素出现则有递增三元子序列
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length <= 3) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int cmin = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] > min && nums[i] <= cmin) {
                cmin = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
