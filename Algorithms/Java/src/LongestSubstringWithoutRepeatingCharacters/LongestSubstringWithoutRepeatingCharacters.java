import java.util.HashMap;

/**
 * Created by tongqi on 2017/4/18.
 * Email: tongqicode@126.com
 */

//解题思路：双指针去记录当下所模拟的子串的首尾，注意判断当前字符到底是属于上个模拟的子串还是当下所模拟的子串，复杂度O(N)

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        //int l = 0, r = 0, ans = 0, len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!hashMap.containsKey(s.charAt(i)) || hashMap.get(s.charAt(i)) < l) {
                r++;
                len++;
                hashMap.put(s.charAt(i), i);
                ans = Math.max(ans, len);
            } else {
                ans = Math.max(len, ans);
                l = hashMap.get(s.charAt(i)) + 1;
                len = r - l + 1;

                r++;
                hashMap.put(s.charAt(i), i);
            }
        }
        return ans;
    }
}
