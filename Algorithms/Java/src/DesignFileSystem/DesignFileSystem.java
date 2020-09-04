package src.DesignFileSystem;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mingqiao
 * @Date 2020/9/4
 */
public class DesignFileSystem {

    private Map<String, Integer> pathMap;

    public DesignFileSystem() {
        this.pathMap = new HashMap<>();
        this.pathMap.put("", 0);
    }

    public boolean createPath(String path, int value) {
        if (pathMap.containsKey(path)) {
            return false;
        }

        //父文件夹需要存在
        int lastSlashIndex = path.lastIndexOf("/");
        if (!pathMap.containsKey(path.substring(0, lastSlashIndex))) {
            return false;
        }
        pathMap.put(path, value);
        return true;
    }

    public int get(String path) {
        return pathMap.get(path) != null ? pathMap.get(path) : -1;
    }
}
