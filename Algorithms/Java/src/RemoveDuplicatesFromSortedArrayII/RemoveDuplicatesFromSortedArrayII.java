package src.RemoveDuplicatesFromSortedArrayII;

/**
 * @author tongqi
 * @date 2025/11/30
 */
public class RemoveDuplicatesFromSortedArrayII {

    /**
     * 删除排序数组中的重复项，使得每个元素最多出现两次
     * 
     * @param nums 排序数组
     * @return 删除重复项后数组的新长度
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0, count = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
                count = 1;
            } else if (count < 2) {
                i++;
                nums[i] = nums[j];
                count++;
            }
        }
        return i + 1;
    }
}

