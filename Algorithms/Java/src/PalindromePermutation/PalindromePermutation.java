package src.PalindromePermutation;

import java.util.HashMap;

/**
 * @author mingqiao
 * @Date 2020/2/16
 */
public class PalindromePermutation {

    /**
     * 如果s长度为奇数，那么只允许1个字符出现1次其他字符偶数次；如果s长度为偶数，那么所有字符都得出现偶数次
     *
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, (pre, one) -> pre + one);
        }
        int count = 0;
        for (char key : map.keySet()) {
            count += map.get(key) % 2;
        }
        return count <= 1;
    }
}
