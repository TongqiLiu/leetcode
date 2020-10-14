package src.StudentAttendanceRecordI;

/**
 * @author mingqiao
 * @Date 2020/10/14
 */
public class StudentAttendanceRecordI {

    /**
     * 题目地址：https://leetcode-cn.com/problems/student-attendance-record-i/
     * 模拟一下即可，复杂度O(N)
     *
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        //mark一个一行搞定的题解...
        //return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");

        if (s == null || s.length() == 0) {
            return false;
        }
        char[] ch = s.toCharArray();

        int ca = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 'A') {
                ca++;
                if (ca >= 2) {
                    return false;
                }
            } else if (ch[i] == 'L') {
                int cl = 1;
                while (i + 1 < ch.length && ch[i + 1] == ch[i]) {
                    cl++;
                    i++;
                }
                if (cl >= 3) {
                    return false;
                }
            }
        }
        return true;
    }
}
