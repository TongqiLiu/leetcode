package src.StringsDifferByOneCharacter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mingqiao
 * @Date 2020/9/10
 */
public class StringsDifferByOneCharacter {

    /**
     * 设单词的均摊长度为k，则复杂度为O(n * k ^ 2)
     *
     * @param dict
     * @return
     */
    public boolean differByOne(String[] dict) {
        Set<String> set = new HashSet<>();
        for (String word : dict) {
            char[] letters = word.toCharArray();

            List<String> tmp = new ArrayList<>();
            String sortWord = new String(letters);
            for (int i = 0; i < letters.length; i++) {
                String str = sortWord.substring(0, i) + sortWord.substring(i + 1) + i;
                if (set.contains(str)) {
                    return true;
                }
                tmp.add(str);
            }
            set.addAll(tmp);
        }
        return false;
    }
}
