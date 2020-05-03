package src.CuttingRope;

/**
 * @author mingqiao
 * @Date 2020/4/2
 */
public class CuttingRope {

    /**
     * 贪心策略，>4时能切出3就切出3
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        return n <= 3 ? n - 1 : (int)dfs(n);
    }

    private long dfs(long n) {
        return n > 4 ? (dfs(n - 3) * 3) % 1000000007 : n;
    }
}
