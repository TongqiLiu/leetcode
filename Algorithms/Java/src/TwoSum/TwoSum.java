import java.util.HashMap;

/**
 * Created by tongqi on 2017/4/11.
 * Email: tongqicode@126.com
 */

//解题思路：哈希表寻找一个数的"补数"存不存在，复杂度O(n)

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[] {hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        try {
            throw new Exception("Solution is not exists");
        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace();
        }
        return new int[]{};
    }
}
