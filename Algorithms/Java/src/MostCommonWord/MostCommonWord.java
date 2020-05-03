package src.MostCommonWord;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author mingqiao
 * @Date 2020/3/26
 */
public class MostCommonWord {

    /**
     * 模拟题，有点小技巧：
     * Set中要加入空字符串""，以排除连续非字母字符的情况
     * paragraph末尾需补个非字母字符，简化最后一个单词逻辑
     *
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += "#";
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        set.add("");

        String res = "";
        int times = 0;

        int start = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int end = 0; end < paragraph.length(); end++) {
            char c = paragraph.charAt(end);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            } else {
                //利用双指针截取出一个单词，并统一转为小写
                String word = paragraph.substring(start, end);
                word = word.toLowerCase();
                if (!set.contains(word)) {
                    map.merge(word, 1, (pre, one) -> pre + one);
                    if (map.get(word) > times) {
                        res = word;
                        times = map.get(word);
                    }
                }
                start = end + 1;
            }
        }
        return res;
    }
}
