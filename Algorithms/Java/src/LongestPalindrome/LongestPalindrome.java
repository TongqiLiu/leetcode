package src.LongestPalindrome;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author mingqiao
 * @Date 2020/3/19
 */
public class LongestPalindrome {

    /**
     * 偶数随便加，奇数的话最多有一个能额外放在中间
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        Map<Integer, Integer> count = s.chars().boxed()
            .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));

        int ans = count.values().stream().mapToInt(i -> i - (i & 1)).sum();
        return ans < s.length() ? ans + 1 : ans;
    }
}
