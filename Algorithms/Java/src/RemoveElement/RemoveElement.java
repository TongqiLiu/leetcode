package src.RemoveElement;

/**
 * author: mingqiao
 * Date: 2019/1/25
 */

//题解：和上一题差不多，直接模拟
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[cnt++] = nums[i];
            }
        }
        return cnt;
    }
}
