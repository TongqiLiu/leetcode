package src.PyramidTransitionMatrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mingqiao
 * @Date 2020/8/31
 */
public class PyramidTransitionMatrix {

    private Map<String, List<Character>> map;

    /**
     * 题目地址：https://leetcode-cn.com/problems/pyramid-transition-matrix/
     * dfs爆搜
     *
     * @param bottom
     * @param allowed
     * @return
     */
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        map = new HashMap<>();
        for (String allow : allowed) {
            String base = allow.substring(0, 2);
            if (!map.containsKey(base)) {
                map.put(base, new ArrayList<>());
            }
            map.get(base).add(allow.charAt(2));
        }
        return dfs(bottom);
    }

    private boolean dfs(String bottom) {
        //到顶则认为OK
        if (bottom.length() == 1) {
            return true;
        }
        //如果bottom中有未出现过的方块底层说明不能搭成金字塔
        for (int i = 0; i < bottom.length() - 1; ++i) {
            if (!map.containsKey(bottom.substring(i, i + 2))) {
                return false;
            }
        }
        // 根据bottom生成所有可能的上层方块
        List<String> list = new ArrayList<>();
        getUppers(bottom, list, new StringBuilder(), 0);
        for (String upper : list) {
            if (dfs(upper)) {
                return true;
            }
        }
        return false;
    }

    private void getUppers(String bottom, List<String> list, StringBuilder sb, int st) {
        if (st == bottom.length() - 1) {
            list.add(sb.toString());
            return;
        }
        for (Character c : map.get(bottom.substring(st, st + 2))) {
            sb.append(c);
            getUppers(bottom, list, sb, st + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
