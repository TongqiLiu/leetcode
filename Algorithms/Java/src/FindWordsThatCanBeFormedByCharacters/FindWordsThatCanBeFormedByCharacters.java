package src.FindWordsThatCanBeFormedByCharacters;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/3/17
 */
public class FindWordsThatCanBeFormedByCharacters {

    /**
     * 模拟一下
     *
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        int[] charMap = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            charMap[chars.charAt(i) - 'a']++;
        }
        int res = 0;
        int[] map = new int[26];
        for (String s : words) {
            boolean flag = true;
            Arrays.fill(map, 0);

            for (int i = 0; i < s.length(); i++) {
                map[s.charAt(i) - 'a']++;
                if (map[s.charAt(i) - 'a'] > charMap[s.charAt(i) - 'a']) {
                    flag = false;
                }
            }
            if (flag) {
                res += s.length();
            }
        }
        return res;
    }
}
