package src.GreatestCommonDivisorOfStrings;

import java.util.Objects;

/**
 * @author mingqiao
 * @Date 2020/3/12
 */
public class GreatestCommonDivisorOfStrings {

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 判下bad case，求下两字符串长度的最大公约数
     *
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
        if (!Objects.equals(str1 + str2, str2 + str1)) { return ""; }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }
}
