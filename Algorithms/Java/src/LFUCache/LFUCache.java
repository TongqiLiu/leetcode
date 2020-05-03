package src.LFUCache;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author mingqiao
 * @Date 2020/3/30
 */
public class LFUCache {

    private int cap;
    private int minFreq;
    private HashMap<Integer, Integer> map;
    private HashMap<Integer, Integer> freqMap;
    private HashMap<Integer, LinkedHashSet<Integer>> freqList;

    /**
     * cap表示容量
     * minFreq表示目前集合里出现最低的频次，
     * map记录每个key-value，
     * freqMap记录每个key的出现的频次，
     * freqList记录每个频次对应的key-list集合
     *
     * @param capacity
     */
    public LFUCache(int capacity) {
        minFreq = 1;
        cap = capacity;
        map = new HashMap<>();
        freqMap = new HashMap<>();
        freqList = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int count = freqMap.get(key);
        freqMap.put(key, count + 1);
        freqList.get(count).remove(key);
        LinkedHashSet<Integer> minFreqList = freqList.get(minFreq);
        if (minFreqList == null || minFreqList.size() == 0) {
            minFreq++;
        }

        freqList.merge(count + 1, new LinkedHashSet<Integer>() {{
                add(key);
            }},
            (pre, one) -> {
                pre.addAll(one);
                return pre;
            }
        );
        return map.get(key);
    }

    public void put(int key, int value) {
        if (cap <= 0) {
            return;
        }
        if (get(key) != -1) {
            map.put(key, value);
            return;
        }

        //新增元素如果超过容量，去除最低频次元素
        if (map.size() >= cap) {
            Integer removeKey = freqList.get(minFreq).iterator().next();
            map.remove(removeKey);
            freqMap.remove(removeKey);
            freqList.get(minFreq).remove(removeKey);
        }
        minFreq = 1;
        map.put(key, value);
        freqMap.put(key, 1);
        freqList.merge(1, new LinkedHashSet<Integer>() {{
                add(key);
            }},
            (pre, one) -> {
                pre.addAll(one);
                return pre;
            }
        );
    }
}
