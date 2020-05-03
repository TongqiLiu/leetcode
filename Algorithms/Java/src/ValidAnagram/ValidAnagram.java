package src.ValidAnagram;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author mingqiao
 * @Date 2020/3/12
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);
        return String.valueOf(sa).equals(String.valueOf(ta));
    }
}
