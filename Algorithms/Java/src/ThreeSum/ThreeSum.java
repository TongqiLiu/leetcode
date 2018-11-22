package src.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author: mingqiao
 * Date: 2018/11/22
 */

//题解：先排序，枚举第一个数a，然后剩下的数中寻找b + c == -a的方案，从左向右扫一遍，复杂度O(N ^ 2)
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int sum = -a;

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int b = nums[l], c = nums[r];

                if (b + c == sum) {
                    l++;
                    r--;

                    String string = "" + a + b + c;
                    if(set.contains(string)) {
                        continue;
                    } else {
                        set.add(string);
                    }

                    List<Integer> list = Arrays.asList(a, b, c);
                    result.add(list);
                }
                if (b + c < sum) {l++;}
                if (b + c > sum) {r--;}
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        threeSum(nums);
    }
}
