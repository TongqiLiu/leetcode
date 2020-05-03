package src.FlipGame;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/3/5
 */
public class FlipGame {

    /**
     * 一次遍历将连续的两个+号替换
     *
     * @param s
     * @return
     */
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(i, '-');
                sb.setCharAt(i + 1, '-');
                ans.add(sb.toString());
            }
        }
        return ans;
    }
}
