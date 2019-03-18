package src.SubstringwithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: mingqiao
 * Date: 2019/3/18
 */

//题解：核心的思路就在于统计单词出现的次数，每次右滑的长度为wordLen * len，整体复杂度o(N)
public class SubstringwithConcatenationOfAllWords {

    private static final int MOD = 100000007;

    public static long getHashCode(String string) {
        int len = string.length();
        long hash = 0;
        for (int i = 0; i < len; i++) {
            char ch = string.charAt(i);
            hash = (hash * 26 + (ch - 'A' + 1)) % MOD;
        }
        return hash;
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return new ArrayList<>();
        }
        Map<String, Integer> counts = new HashMap<>();
        for (final String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        List<Integer> indexes = new ArrayList<>();
        int n = s.length(), num = words.length, len = words[0].length();
        for (int i = 0; i <= n - num * len; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                String word = s.substring(i + j * len, i + (j + 1) * len);
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("goodgoodgoodgoodgoodwordgoodgoodgoodgood", new String[] {"good", "good", "good", "good"}));
    }
}
