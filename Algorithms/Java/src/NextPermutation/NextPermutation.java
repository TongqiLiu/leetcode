package src.NextPermutation;

import java.util.Arrays;
import java.util.Collections;

/**
 * author: mingqiao
 * Date: 2019/3/18
 */

//题解：从数组尾部遍历，当前位置能交换则交换然后尾部，如果不能交换则依旧尾部排序保证下一部交换正确
public class NextPermutation {

    public void swapNums(int i, int j, int num[]) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    swapNums(i, j, nums);
                    Arrays.sort(nums, i + 1, nums.length);
                    return;
                }
            }
            Arrays.sort(nums, i, nums.length);
        }
    }
}
