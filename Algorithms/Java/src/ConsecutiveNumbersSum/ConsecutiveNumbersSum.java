package src.ConsecutiveNumbersSum;

/**
 * @author mingqiao
 * @Date 2020/9/8
 */
public class ConsecutiveNumbersSum {

    /**
     * 由等差求和公式易知：sum = b * (b + 2 * a - 1)，即2 * sum = b * (b + 2 * a - 1)，
     * 2a-1肯定是奇数，故定义c = b + 2a - 1肯定和b的奇偶性相反，故题目转化为求多少组奇偶数满足2 * sum = b * c
     * 时间复杂度O(根号N)
     *
     * @param N
     * @return
     */
    public int consecutiveNumbersSum(int N) {
        int sum = N * 2, ans = 0, b = 1;
        while (b * b <= sum) {
            //是否能整除及奇偶性相反
            if (sum % b == 0 && (((sum / b + b) & 1) == 1)) {
                ans++;
            }
            b++;
        }
        return ans;
    }
}
