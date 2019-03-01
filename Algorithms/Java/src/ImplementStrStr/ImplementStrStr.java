package src.ImplementStrStr;

/**
 * author: mingqiao
 * Date: 2019/2/20
 */

//题解：可以考虑暴力，这里使用KMP算法，时间复杂度O(M + N)
public class ImplementStrStr {

    /**
     * KMP算法核心是Next数组的处理，Next[i]标识模式串i位置的前缀集合和后缀集合的最大交集长度
     * @param haystack
     * @param next
     */
    public static void getNext(String haystack, int[] next) {
        next[0] = -1;
        int i = 0, j = -1, len = haystack.length();
        while (i < len - 1) {
            if (j == -1 || haystack.charAt(i) == haystack.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }

    public static int strStr(String haystack, String needle) {
        int[] next = new int[needle.length() + 1];
        getNext(needle, next);

        int i = 0, j = 0;
        int hayLen = haystack.length(), needLen = needle.length();
        while (i < hayLen && j < needLen) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == needLen) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        strStr("mississippi", "issip");
    }
}
