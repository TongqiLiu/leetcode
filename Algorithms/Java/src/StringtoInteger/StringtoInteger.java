/**
 * Created by tongqi on 2017/4/21.
 * Email: tongqicode@126.com
 */

//解题思路：模拟，但是有很多种情况需要特判，比如前导0，前导空格，不合法的int变量，变量超过int范围等

public class StringtoInteger {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0 || str.equals("+") || str.equals("-")) return 0;

        int cur = 0, flag = 1, length = str.length();
        long ans = 0;

        while (cur < length) {
            if (str.charAt(cur) == '0' || str.charAt(cur) == ' ') cur++;
            else break;
        }
        if (str.charAt(cur) == '+' || str.charAt(cur) == '-') {
            if (str.charAt(cur) == '-') flag = -1;
            cur++;
        }
        for (int i = cur; i < length; i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) break;
            ans = ans * 10 + str.charAt(i) - '0';

            if (ans > Integer.MAX_VALUE) {
                if(flag == -1) return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
        }
        ans *= flag;

        return (int) ans;
    }
}
