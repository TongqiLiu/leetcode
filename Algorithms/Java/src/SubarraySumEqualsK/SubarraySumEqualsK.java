package src.SubarraySumEqualsK;

import java.util.HashMap;

/**
 * @author mingqiao
 * @Date 2020/2/1
 */
public class SubarraySumEqualsK {

    /**
     * 暴力解法，O(N ^ 2)，哈希表可以降到O(N)，保留前缀和，遍历到某位置j数组和为sum[j]，前置位置i和为sum[i]
     * ，则满足sum[j] - sum[i] = k，即sum[j] - k = sum[i]时即可
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.merge(sum, 1, (pre, one) -> pre + one);
        }
        return count;
    }
}
