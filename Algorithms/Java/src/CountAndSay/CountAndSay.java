package src.CountAndSay;

/**
 * @author mingqiao
 * @Date 2019/8/18
 */
public class CountAndSay {

    /**
     * 读懂题意后，模拟就行了注意边界
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        int count = 1;
        StringBuilder ans = new StringBuilder();
        String prefix = countAndSay(n - 1) + '#';
        for (int i = 0; i < prefix.length() - 1; i++) {
            if (prefix.charAt(i) == prefix.charAt(i + 1)) {
                count++;
            } else {
                ans.append(count);
                ans.append(prefix.charAt(i));
                count = 1;
            }
        }
        return ans.toString();
    }
}
