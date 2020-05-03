package src.Numberof1Bits;

/**
 * @author mingqiao
 * @Date 2020/2/6
 */
public class Numberof1Bits {

    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans++;
            n = n & (n - 1);
        }
        return ans;
    }
}
