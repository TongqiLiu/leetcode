package src.ContainerWithMostWater;

/**
 * Created by tongqi on 2018/8/02.
 * Email: tongqicode@126.com
 */

//题解：双指针，哪边高度较低哪边移动，以便获取最优解

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int ans = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int hl = height[l], hr = height[r];
            if(hl <= hr) {
                ans = Math.max(ans, hl * (r - l));
                l++;
            } else {
                ans = Math.max(ans, hr * (r - l));
                r--;
            }
        }
        return ans;
    }
}