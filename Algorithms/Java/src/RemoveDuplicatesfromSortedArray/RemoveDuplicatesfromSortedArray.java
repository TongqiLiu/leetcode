package src.RemoveDuplicatesfromSortedArray;

/**
 * author: mingqiao
 * Date: 2019/1/25
 */

//题解: 直接模拟往后一直加数
public class RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {
        int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[cnt] != nums[i]) {
                nums[++cnt] = nums[i];
            }
        }
        return cnt + 1;
    }
}
