package src.IsSubsequence;

/**
 * @author tongqi
 * @date 2025/11/23
 */
public class IsSubsequence {

    /**
     * 判断s是否是t的子序列
     * 
     * @param s 子序列字符串
     * @param t 目标字符串
     * @return 如果s是t的子序列返回true，否则返回false
     */
    public boolean isSubsequence(String s, String t) {
        boolean flag = false;
        if (s == null || t == null) {
            return flag;
        }
        if (s.isEmpty()) {
            return true;
        }

        int k = 0;
        for (int i = 0; i <= s.length() - 1; i++) {

            flag = false;
            for (int j = k; j <= t.length() - 1; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    k = j + 1;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return flag;
            }
        }
        return flag;
    }
}

