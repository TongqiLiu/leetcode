package src.ValidPalindrome;

/**
 * @author mingqiao
 * @Date 2020/3/12
 */
public class ValidPalindrome {

    /**
     * 字符串方法调用
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}
