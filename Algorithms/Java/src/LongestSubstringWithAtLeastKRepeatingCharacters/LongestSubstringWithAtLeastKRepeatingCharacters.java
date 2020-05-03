package src.LongestSubstringWithAtLeastKRepeatingCharacters;

/**
 * @author mingqiao
 * @Date 2020/2/24
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    /**
     * 递归分治处理：统计字符出现频次，如果发现有字符小于K次那么这个字符一定不存在于结果串之中，
     * 故指针从两边向中间收缩至两侧字符均>=k次为止，得到的子串再根据其内每个<K的字符进行枚举分治
     * 时间复杂度O(N)
     *
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k > s.length()) {
            return 0;
        }
        if (k <= 1) {
            return s.length();
        }
        return divide(s.toCharArray(), k, 0, s.length() - 1);
    }

    private static int divide(char[] chars, int k, int l, int r) {
        if (r - l + 1 < k) {
            return 0;
        }
        int[] nums = new int[26];
        for (int i = l; i <= r; ++i) {
            nums[chars[i] - 'a']++;
        }

        //左右指针收缩
        while (r - l + 1 >= k && nums[chars[l] - 'a'] < k) {
            ++l;
        }
        while (r - l + 1 >= k && nums[chars[r] - 'a'] < k) {
            --r;
        }
        if (r - l + 1 < k) {
            return 0;
        }

        for (int i = l; i <= r; ++i) {
            if (nums[chars[i] - 'a'] < k) {
                return Math.max(divide(chars, k, l, i - 1), divide(chars, k, i + 1, r));
            }
        }
        return r - l + 1;
    }
}
