package src.KillProcess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/2/27
 */
public class KillProcess {

    public void dfs(HashMap<Integer, List<Integer>> map, List<Integer> res, int kill) {
        if (map.containsKey(kill)) {
            for (int id : map.get(kill)) {
                res.add(id);
                dfs(map, res, id);
            }
        }
    }

    /**
     * 将父子节点存储起来，然后dfs递归删除
     *
     * @param pid
     * @param ppid
     * @param kill
     * @return
     */
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) > 0) {
                int finalI = i;
                map.merge(ppid.get(i), new ArrayList<Integer>() {{
                    add(pid.get(finalI));
                }}, (pre, one) -> {
                    pre.addAll(one);
                    return pre;
                });
            }
        }
        List<Integer> res = new ArrayList<Integer>() {{
            add(kill);
        }};
        dfs(map, res, kill);
        return res;
    }
}
