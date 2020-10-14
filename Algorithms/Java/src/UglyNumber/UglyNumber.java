package src.UglyNumber;

/**
 * @author mingqiao
 * @Date 2020/10/14
 */
public class UglyNumber {

    /**
     * 题目地址：https://leetcode-cn.com/problems/ugly-number/
     * 模拟一下即可
     *
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
