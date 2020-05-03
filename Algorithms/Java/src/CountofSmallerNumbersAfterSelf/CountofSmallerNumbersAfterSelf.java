package src.CountofSmallerNumbersAfterSelf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author mingqiao
 * @Date 2020/2/15
 */
public class CountofSmallerNumbersAfterSelf {

    private class Bit {

        private int[] bit;
        private int n;

        public Bit(int n) {
            this.n = n;
            bit = new int[n + 1];
        }

        private int lowBit(int i) {
            return i & (-i);
        }

        public void update(int i, int x) {
            while (i <= n) {
                bit[i] += x;
                i += lowBit(i);
            }
        }

        public int sum(int i) {
            int res = 0;
            while (i > 0) {
                res += bit[i];
                i -= lowBit(i);
            }
            return res;
        }
    }

    /**
     * 先离散化，然后树状数组倒着更新即可算出来
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }

        int n = nums.length;
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        int rank = 1;
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (Integer number : set) {
            rankMap.put(number, rank++);
        }

        Bit bit = new Bit(n);
        for (int i = n - 1; i >= 0; i--) {
            rank = rankMap.get(nums[i]);
            list.add(bit.sum(rank - 1));
            bit.update(rank, 1);
        }
        Collections.reverse(list);
        return list;
    }
}
