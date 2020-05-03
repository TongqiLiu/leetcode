package src.LastRemaining;

/**
 * @author mingqiao
 * @Date 2020/3/30
 */
public class LastRemaining {

    /**
     * 约瑟夫问题，从最后剩下的那个数字反向往前推，即：(当前位置index + m) % 上一轮剩余数字的个数
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
