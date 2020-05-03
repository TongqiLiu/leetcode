package src.TopKFrequentElements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author mingqiao
 * @Date 2020/3/3
 */
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }

        Map<Integer, Integer> countMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.merge(nums[i], 1, (pre, one) -> pre + one);
        }
        ArrayList<Entry<Integer, Integer>> entries = new ArrayList<>(countMap.entrySet());
        entries.sort((o1, o2) -> o2.getValue() - o1.getValue());

        for (Entry<Integer, Integer> entry : entries) {
            list.add(entry.getKey());
        }
        return list.stream().limit(k).collect(Collectors.toList());
    }
}
