package src.AddBinary;

/**
 * @author mingqiao
 * @Date 2020/1/1
 */
public class AddBinary {

    /**
     * 短字符串前置位补0处理
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int remain = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = remain;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            remain = sum / 2;
        }
        ans.append(remain == 1 ? remain : "");
        return ans.reverse().toString();
    }
}
