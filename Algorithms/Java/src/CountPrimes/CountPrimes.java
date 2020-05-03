package src.CountPrimes;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author mingqiao
 * @Date 2020/2/23
 */
public class CountPrimes {

    /**
     * 埃氏筛选法
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }

        Boolean[] vis = new Boolean[n + 1];
        Arrays.fill(vis, true);
        for (int i = 2; i * i < n; i++) {
            if (vis[i]) {
                for (int j = i * i; j < n; j += i) {
                    vis[j] = false;
                }
            }
        }
        //减去多余的0，1还有N+1
        return (int)Stream.of(vis).filter(v -> v).count() - 3;
    }
}
