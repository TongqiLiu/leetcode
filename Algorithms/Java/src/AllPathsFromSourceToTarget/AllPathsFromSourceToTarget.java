package src.AllPathsFromSourceToTarget;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    private List<List<Integer>> res = new ArrayList<>();

    /**
     * 经典回溯DFS问题
     *
     * @param graph
     * @return
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res.clear();
        if (graph == null || graph.length == 0) return res;
        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(0);
        dfs(path, 0, graph);
        return res;
    }

    private void dfs(LinkedList<Integer> path, int index, int[][] graph) {
        if (graph[index].length == 0 && index == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i : graph[index]) {
            path.addLast(i);
            dfs(path, i, graph);
            path.removeLast();
        }
    }
}
