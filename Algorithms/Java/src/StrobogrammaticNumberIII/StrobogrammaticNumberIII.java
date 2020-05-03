package src.StrobogrammaticNumberIII;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mingqiao
 * @Date 2020/3/2
 */
public class StrobogrammaticNumberIII {

    private char[] dl = new char[] {'0', '1', '6', '8', '9'};
    private char[] dr = new char[] {'0', '1', '9', '8', '6'};

    boolean compare(String a, String b) {
        if (a.length() != b.length()) {
            return a.length() > b.length();
        }
        return a.compareTo(b) > 0;
    }

    boolean checkValid(String num, String low, String high) {
        return compare(num, low) && compare(high, num);
    }

    /**
     * bfs所有可能性，排除一些前导0的bad case
     *
     * @param low
     * @param high
     * @return
     */
    public int strobogrammaticInRange(String low, String high) {
        int ans = 0;
        Queue<String> queue = new LinkedList<>();

        queue.offer("");
        queue.offer("0");
        queue.offer("1");
        queue.offer("8");

        while (!queue.isEmpty()) {
            String cur = queue.poll();

            if (cur.length() >= low.length() && cur.length() <= high.length()) {
                if (!(cur.charAt(0) == '0' && cur.length() > 1)) {
                    if (checkValid(cur, low, high)) {
                        ans++;
                    }
                }
            }
            if (cur.length() > high.length()) {
                continue;
            }

            for (int i = 0; i < 5; ++i) {
                String next = dl[i] + cur + dr[i];
                queue.offer(next);
            }
        }

        return ans;
    }
}
