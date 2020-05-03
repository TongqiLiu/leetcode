package src.ContainsDuplicate;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/2/29
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        return Arrays.stream(nums).distinct().count() != nums.length;
    }
}
