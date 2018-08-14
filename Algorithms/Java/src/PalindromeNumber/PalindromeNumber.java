package src.PalindromeNumber;

/**
 * Created by tongqi on 2017/4/21.
 * Email: tongqicode@126.com
 */

//解题思路：字符串对称比较下可以解决，也可以利用取模再累乘法算法其反转出的数，比较两者是否相等

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;

        int newnumber = 0, tmp = x;
        while (tmp != 0) {
            newnumber = newnumber * 10 + tmp % 10;
            tmp /= 10;
        }
        return newnumber == x;
    }
}
