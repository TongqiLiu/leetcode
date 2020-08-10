package src.CountBinarySubstrings;

/**
 * @author mingqiao
 * @Date 2020/8/10
 */
public class CountBinarySubstrings {

    /**
     * 题目地址：https://leetcode-cn.com/problems/count-binary-substrings/
     * 先统计连续的0和1区间段分别有多少个，比如00110011，即为2222，然后相邻数字取小者相加
     *
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int cnt = 1;
        int ans = 0, lastCnt = 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cnt++;
            } else {
                ans += Math.min(lastCnt, cnt);
                lastCnt = cnt;
                cnt = 1;
            }
        }
        ans += Math.min(lastCnt, cnt);
        return ans;
    }
}
