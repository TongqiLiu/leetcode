package src.InsertDeleteGetRandomO1Duplicates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author mingqiao
 * @Date 2020/3/19
 */
public class RandomizedCollection {

    private ArrayList<Integer> list;
    private HashMap<Integer, Set<Integer>> indexMap;

    /**
     * Initialize your data structure here.
     * random：array或list O(1)可实现
     * insert：list o(1)可实现
     * remove：通过hashMap索引找到元素在list的位置，由于数字顺序无关，故删除时每次将列表尾部元素挪移到被删除元素位置上再更新索引
     */
    public RandomizedCollection() {
        list = new ArrayList<>();
        indexMap = new HashMap<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not
     * already contain the specified element.
     */
    public boolean insert(int val) {
        list.add(val);
        indexMap.merge(val, new HashSet<Integer>() {{
                add(list.size() - 1);
            }},
            (pre, one) -> {
                pre.addAll(one);
                return pre;
            }
        );
        return indexMap.get(val).size() == 1;
    }

    /**
     * Removes a value from the collection. Returns true if the collection
     * contained the specified element.
     */
    public boolean remove(int val) {
        if (!indexMap.containsKey(val) || indexMap.get(val).size() == 0) {
            return false;
        }
        Set<Integer> indexSet = indexMap.get(val);
        Integer removeIndex = indexSet.iterator().next();
        indexSet.remove(indexSet.iterator().next());

        //尾部元素挪移
        int lastValue = list.get(list.size() - 1);
        list.set(removeIndex, lastValue);

        Set<Integer> lastIndexSet = indexMap.get(lastValue);
        lastIndexSet.add(removeIndex);
        lastIndexSet.remove(list.size() - 1);
        list.remove(list.size() - 1);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}
