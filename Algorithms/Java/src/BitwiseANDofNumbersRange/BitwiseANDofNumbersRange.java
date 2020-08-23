package src.BitwiseANDofNumbersRange;

/**
 * @author mingqiao
 * @Date 2020/8/23
 */
public class BitwiseANDofNumbersRange {

    /**
     * 题目地址：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
     * 不断清除lowbit(n)，清除[m,n]区间内的非公共前缀1，复杂度O(logN)
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n = n & (n - 1);
        }
        return n;
    }
}
