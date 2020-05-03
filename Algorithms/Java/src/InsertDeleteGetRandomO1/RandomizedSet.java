package src.InsertDeleteGetRandomO1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author mingqiao
 * @Date 2020/3/19
 */
public class RandomizedSet {

    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> indexMap;

    /**
     * Initialize your data structure here.
     * 和RandomizedCollection很类似，使用indexMap存储位置索引
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        indexMap = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }
        list.add(val);
        indexMap.put(val, list.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        Integer index = indexMap.get(val);
        int lastValue = list.get(list.size() - 1);

        list.set(index, lastValue);
        indexMap.put(lastValue, index);

        indexMap.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}
