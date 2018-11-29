package src.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * author: mingqiao
 * Date: 2018/11/29
 */

//题解：两种解法，第一种解法枚举a，然后找target - a，解题思路和3SUM一致，时间复杂度O(N ^ 3)。
//第二种解法如代码所示，枚举两数和，这样转为了2SUM问题，时间复杂度O(N ^ 2 * log(N))
public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 4) {
            return result;
        }

        Set<String> set = new HashSet<>();

        Arrays.sort(nums);
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                Integer number = nums[i] + nums[j];
                List<Integer> subList = Arrays.asList(i, j);

                map.putIfAbsent(number, new ArrayList<>());
                map.get(number).add(subList);
            }
        }

        Set<Integer> keySet = map.keySet();
        for (Integer leftValue : keySet) {
            List<List<Integer>> lists1 = map.get(leftValue);
            List<List<Integer>> lists2 = map.get(target - leftValue);

            if(lists1 == null || lists2 == null) {
                continue;
            }

            for (List<Integer> leftSet : lists1) {
                int a = leftSet.get(0), b = leftSet.get(1);

                for (List<Integer> rightSet : lists2) {
                    int c = rightSet.get(0), d = rightSet.get(1);

                    if(b < c) {
                        List<Integer> oneResult = Arrays.asList(nums[a], nums[b], nums[c], nums[d]);
                        oneResult.sort(Comparator.comparingInt(o -> o));

                        String string = "" + oneResult.get(0) + oneResult.get(1) + oneResult.get(2) + oneResult.get(3);
                        if(set.contains(string)) {
                            continue;
                        } else {
                            set.add(string);
                            result.add(oneResult);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-3, -2, -1, 0, 0, 1, 2, 3};
        System.out.print(fourSum(nums, 0));
    }
}
