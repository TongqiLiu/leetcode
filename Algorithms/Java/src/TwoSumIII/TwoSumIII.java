package src.TwoSumIII;

import java.util.HashMap;
import java.util.Map;

import sun.jvm.hotspot.debugger.cdbg.basic.BasicLineNumberMapping;

/**
 * @author mingqiao
 * @Date 2020/2/7
 */
public class TwoSumIII {

    private HashMap<Integer, Integer> numMap;

    /**
     * Initialize your data structure here.
     */
    public TwoSumIII() {
        numMap = new HashMap<>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        numMap.merge(number, 1, (pre, one) -> pre + one);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            int need = value - entry.getKey();
            if (numMap.containsKey(need)) {
                if (need == entry.getKey()) {
                    return entry.getValue() > 1;
                }
                return true;
            }
        }
        return false;
    }

}
