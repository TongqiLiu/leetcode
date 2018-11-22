package src.ThreeSumClosest;

import java.util.Arrays;

/**
 * author: mingqiao
 * Date: 2018/11/22
 */

//题解：和3Sum那题差不多，无非是寻求最接近b + c == target - a的方案，复杂度O(N ^ 2)
public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int sum = target - a;

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int b = nums[l], c = nums[r];

                if (b + c == sum) {
                    res = target;
                    break;
                }
                if (b + c < sum) {
                    l++;
                }
                if (b + c > sum) {
                    r--;
                }
                if(Math.abs(target - (a + b + c)) < Math.abs(target - (res))){
                    res = a + b + c;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 2));
    }
}
