package src.OneEditDistance;

/**
 * @author mingqiao
 * @Date 2020/10/12
 */
public class OneEditDistance {

    /**
     * 题目地址：https://leetcode-cn.com/problems/one-edit-distance/
     * 先通过交换默认让ls<lt，然后就只剩两种情况满足条件了，复杂度O(N)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isOneEditDistance(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        if (ls > lt) {
            return isOneEditDistance(t, s);
        }
        if (lt - ls > 1) {
            return false;
        }

        for (int i = 0; i < ls; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (ls == lt) {
                    //替换当前位置，之后的两子串需要完全一致
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    //删掉t串该字符，剩余两子串需要完全一致
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }

        //两字符串不能完全相同
        return ls + 1 == lt;
    }
}
