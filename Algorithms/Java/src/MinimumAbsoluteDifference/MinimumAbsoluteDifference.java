package src.MinimumAbsoluteDifference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author mingqiao
 * @Date 2020/2/19
 */
public class MinimumAbsoluteDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> lists = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return lists;
        }

        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        Map<Integer, List<List<Integer>>> treeMap = new TreeMap<>();
        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(min, arr[i + 1] - arr[i]);
            treeMap.merge(arr[i + 1] - arr[i],
                new ArrayList<>(Collections.singletonList(Arrays.asList(arr[i], arr[i + 1]))),
                (pre, one) -> {
                    pre.addAll(one);
                    return pre;
                });
        }

        return new ArrayList<>(treeMap.values()).get(0);
    }
}
