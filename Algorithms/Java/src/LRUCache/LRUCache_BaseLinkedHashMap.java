package src.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author mingqiao
 * @Date 2020/2/2
 */
public class LRUCache_BaseLinkedHashMap {

    private LRUInnerCache lruInnerCache;

    /**
     * 基于linkedHashMap来实现，是需要重载部分方法即可
     * @param cap
     */
    public LRUCache_BaseLinkedHashMap(int cap) {
        lruInnerCache = new LRUInnerCache(cap);
    }

    public int get(int key) {
        return lruInnerCache.get(key);
    }

    public void put(int key, int value) {
        lruInnerCache.put(key, value);
    }

    private class LRUInnerCache extends LinkedHashMap<Integer, Integer> {

        private int cap;

        LRUInnerCache(int cap) {
            super(cap, 0.75f, true);
            this.cap = cap;
        }

        public int get(int key) {
            Integer value = super.get(key);
            if (value == null) {
                return -1;
            }
            return value;
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return this.size() > cap;
        }
    }

}
