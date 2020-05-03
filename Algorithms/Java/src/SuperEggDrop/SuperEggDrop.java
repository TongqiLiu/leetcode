package src.SuperEggDrop;

/**
 * @author mingqiao
 * @Date 2020/3/11
 */
public class SuperEggDrop {

    /**
     * 地址：https://leetcode-cn.com/problems/super-egg-drop/
     * dp[n][k] 表示用k个鸡蛋测n层最少需要多少步，故枚举第一次在第i层扔鸡蛋：
     * 鸡蛋碎了: 之后用 k-1 个鸡蛋来测量 i-1 层，所以最少需要 dp[i-1][k-1] 次。
     * 鸡蛋没碎: 之后用 k 个鸡蛋来测量 n-i 层，所以最少需要 dp[n-i][k] 次
     * 故最坏情况表示为max(dp[i-1][k-1], dp[n-i][k]) + 1 次。
     * 这个解法复杂度为O(n ^ 2 * k)，会超时
     *
     * @param K
     * @param N
     * @return
     */
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            //初始化1，2个鸡蛋的case
            dp[i][0] = 0;
            dp[i][1] = i;
        }
        for (int k = 2; k <= K; k++) {
            //0层的初始化
            dp[0][k] = 0;
            for (int i = 1; i <= N; i++) {
                //打底值
                dp[i][k] = i;
                for (int j = 1; j <= i; j++) {
                    dp[i][k] = Math.min(dp[i][k], Math.max(dp[j - 1][k - 1], dp[i - j][k]) + 1);
                }
            }
        }
        return dp[N][K];
    }

    /**
     * 类似LIS那道题的O(N*logN)的解题思路，我们改变一下思路，设定dp[k][m]表示k个鸡蛋在m次内最多能测出的层数，依然枚举在第i层扔鸡蛋：
     * 鸡蛋碎了: 测出了(n - i) + dp[k-1][m-1]层的结果，即i以上的楼层确认大于target楼层，能测出的总层数取决于dp[k-1][m-1]往下扔
     * 鸡蛋没碎: 测出了i + dp[k][m-1]的结果，即i层及以下的楼层确认不大于target楼层，能测出的总层数取决于dp[k][m-1]往上扔
     *
     * 那么这个i层我们改如何选择呢，正确选择是 dp[k-1][m-1]+1 层丢鸡蛋，原因：
     * 鸡蛋碎了: 首先排除了该层以上的所有楼层，而对于剩下的dp[k-1][m-1]层楼，我们一定能用k-1个鸡蛋在m-1次内求解，当然这是一种极其理想的情况
     * 鸡蛋没碎: 首先排除了该层以下的dp[k-1][m-1]层楼，那么我们继续往上扔可以测得dp[k][m-1]层楼，故这种情况下，我们总共可以求解dp[k-1][m-1]+dp[k][m-1]+1层楼
     * 第一种情况理论上出现一次我们就可以测出无限高的漏洞，但是在保证有解的前提下，我们只能认定每次仍鸡蛋都是第二种场景
     * 同时我们发现只跟m-1有关，故可以类似背包问题一样滚动数组优化掉，这里就不单写了
     *
     * @param K
     * @param N
     * @return
     */
    public int superEggDrop1(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int m = 1; m <= N; m++) {
            //0个鸡蛋的初始化
            dp[0][m] = 0;
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
                if (dp[k][m] >= N) {
                    return m;
                }
            }
        }
        return N;
    }
}
