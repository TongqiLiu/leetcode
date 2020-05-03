package src.DeleteTreeNodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author mingqiao
 * @Date 2020/2/29
 */
public class DeleteTreeNodes {

    private Set<Integer> set = new HashSet<>();
    private Map<Integer, List<Integer>> map = new HashMap<>();

    /**
     * 先递归遍历一遍子树和为0的节点，再递归计算除去这些子树后的节点数，复杂度O(n)
     *
     * @param nodes
     * @param parent
     * @param value
     * @return
     */
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        if (nodes == 0 || parent == null || value == null) {
            return 0;
        }

        set.clear();
        map.clear();
        for (int i = 0; i < parent.length; i++) {
            int finalI = i;
            map.merge(parent[i], new ArrayList<Integer>() {{
                    add(finalI);
                }},
                (pre, one) -> {
                    pre.addAll(one);
                    return pre;
                });
        }
        sum(0, value);
        return dfs(0);
    }

    private int sum(int node, int[] value) {
        int sum = value[node];
        if (map.containsKey(node)) {
            List<Integer> childs = map.get(node);
            for (Integer child : childs) {
                sum += sum(child, value);
            }
        }
        if (sum == 0) {
            set.add(node);
        }
        return sum;
    }

    private int dfs(int node) {
        if (set.contains(node)) {
            return 0;
        }
        int count = 1;
        if (map.containsKey(node)) {
            List<Integer> childs = map.get(node);
            for (Integer child : childs) {
                count += dfs(child);
            }
        }
        return count;
    }
}
