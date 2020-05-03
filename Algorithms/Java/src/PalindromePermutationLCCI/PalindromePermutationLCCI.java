package src.PalindromePermutationLCCI;

import java.util.HashSet;

/**
 * @author mingqiao
 * @Date 2020/2/19
 */
public class PalindromePermutationLCCI {

    /**
     * 长度为奇数有一个字符出现了1次，长度为偶数所有字符都出现了两次
     *
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.add(c)) {
                set.remove(c);
            }
        }
        return set.size() <= 1;
    }
}
