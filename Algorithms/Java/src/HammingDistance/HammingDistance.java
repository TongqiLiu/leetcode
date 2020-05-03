package src.HammingDistance;

/**
 * @author mingqiao
 * @Date 2020/2/28
 */
public class HammingDistance {

    /**
     * 异或一下找出二进制下不同1的个数，然后Lowbit计算
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        int a = x ^ y;
        int ans = 0;
        while (a > 0) {
            a -= a & (-a);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(4, 8));
    }
}
