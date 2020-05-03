package src.FlipGameII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mingqiao
 * @Date 2020/3/6
 */
public class FlipGameII {

    /**
     * 记忆化搜索，如果反转后的博弈棋局对方无法获得胜利，那么先手获胜，复杂度O(2 ^ N)
     *
     * @param s
     * @return
     */
    public boolean canWin(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                String tmp = s.substring(0, i - 1) + "--" + s.substring(i + 1);
                if (!canWin(tmp)) {
                    return true;
                }
            }
        }
        return false;
    }
}
