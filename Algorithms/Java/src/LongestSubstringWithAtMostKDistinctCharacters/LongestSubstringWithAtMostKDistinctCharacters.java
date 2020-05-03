package src.LongestSubstringWithAtMostKDistinctCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mingqiao
 * @Date 2020/3/3
 */
public class LongestSubstringWithAtMostKDistinctCharacters {

    /**
     * 双指针滑动窗口，维护一个存放字符的hashMap，右指针划到超过K个元素时循环移动左指针，复杂度O(N)
     *
     * @param s
     * @param k
     * @return
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int l = 0, r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            map.merge(ch, 1, (pre, one) -> pre + one);

            while (map.size() > k) {
                char leftCh = s.charAt(l++);
                Integer leftCnt = map.get(leftCh) - 1;
                if (leftCnt > 0) {
                    map.put(leftCh, leftCnt);
                } else {
                    map.remove(leftCh);
                }
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
