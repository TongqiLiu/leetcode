package src.LRUCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author mingqiao
 * @Date 2020/2/2
 */
public class LRUCache {

    /**
     * 基于HashMap记录k-v和数组记录元素访问顺序，数组首元素即为待剔除更新元素
     */
    private Map<Integer, Integer> keys = new HashMap<>();
    private List<Integer> visited = new LinkedList<>();
    private int cap;
    private int num = 0;

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!keys.containsKey(key)) {
            return -1;
        }
        visited.remove((Integer)key);
        visited.add(key);
        return keys.get(key);
    }

    public void put(int key, int value) {
        if (keys.containsKey(key)) {
            visited.remove((Integer)key);
        } else if (num < cap) {
            num++;
        } else {
            keys.remove(visited.get(0));
            visited.remove(0);
        }

        keys.put(key, value);
        visited.add(key);
    }
}
