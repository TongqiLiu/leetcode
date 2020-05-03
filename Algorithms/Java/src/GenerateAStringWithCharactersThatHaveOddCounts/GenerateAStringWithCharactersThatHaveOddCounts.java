package src.GenerateAStringWithCharactersThatHaveOddCounts;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/3/8
 */
public class GenerateAStringWithCharactersThatHaveOddCounts {

    /**
     * 题目地址：https://leetcode-cn.com/problems/generate-a-string-with-characters-that-have-odd-counts/comments/
     * 构造题：
     * 奇数就全部a
     * 偶数就是n-1个a  一个b
     *
     * @param n
     * @return
     */
    public String generateTheString(int n) {
        char[] chars = new char[n];
        Arrays.fill(chars, 'a');
        if (n % 2 == 0) {
            chars[chars.length - 1] = 'b';
        }
        return new String(chars);
    }
}
