package src.FindAllAnagramsInAString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/3/15
 */
public class FindAllAnagramsInAString {

    /**
     * 滑动窗口，计算字符串字符统计值
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return ans;
        }

        int[] dir = new int[26];
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        for (char c : cp) {
            dir[c - 'a']++;
        }

        int[] cur = new int[26];
        for (int i = 0; i < cp.length - 1; i++) {
            cur[cs[i] - 'a']++;
        }

        for (int i = cp.length - 1; i < cs.length; i++) {
            cur[s.charAt(i) - 'a']++;
            if (checkSame(dir, cur)) {
                ans.add(i - cp.length + 1);
            }
            cur[s.charAt(i - cp.length + 1) - 'a']--;
        }
        return ans;
    }

    private boolean checkSame(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
