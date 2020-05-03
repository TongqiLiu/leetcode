package src.ReverseWordsInAStringIII;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/3/12
 */
public class ReverseWordsInAStringIII {

    /**
     * 直接反转，也可以用栈
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        String[] splits = s.split(" ");
        for (int i = 0; i < splits.length; i++) {
            String string = splits[i];
            sb.append(new StringBuffer(string).reverse());
            if (i < splits.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
