package src.MoveZeroes;

/**
 * @author mingqiao
 * @Date 2020/3/15
 */
public class MoveZeroes {

    /**
     * 设置一个指针P，将非0位置的数挪移到P的索引位置上
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[p] = nums[i];
                p++;
            }
        }

        for (int i = p; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
