package src.KthSmallestInLexicographicalOrder;

public class KthSmallestInLexicographicalOrder {

    /**
     * 十叉树，计算出相邻两数满足均<=n时的跨度数量，并以此判定右移or下移
     *
     * @param n
     * @param k
     * @return
     */
    public static int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {

            long step = cal(n, cur, cur + 1);
            if (k < step) {
                //移动一层
                cur *= 10;
                k--;
            } else {
                //右移一步
                k -= step;
                cur = cur + 1;
            }

        }
        return cur;
    }

    /**
     * 统计该子树下的覆盖节点数目
     *
     * @param n
     * @param n1
     * @param n2
     * @return
     */
    private static long cal(int n, long n1, long n2) {
        int ans = 0;
        while (n1 <= n) {
            ans += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        findKthNumber(13, 2);
    }
}
