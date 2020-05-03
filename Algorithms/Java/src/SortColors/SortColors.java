package src.SortColors;

/**
 * @author mingqiao
 * @Date 2020/1/7
 */
public class SortColors {

    /**
     * （l,r）区间内为1，区间外分别为0和2，注意和2交换时因为该值为扫描故需要停下来继续扫描
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1, cur = 0;

        int tmp;
        while (cur <= r) {
            if (nums[cur] == 0) {
                tmp = nums[l];
                nums[l] = nums[cur];
                nums[cur] = tmp;

                l++;
                cur++;
            } else if (nums[cur] == 2) {
                tmp = nums[cur];
                nums[cur] = nums[r];
                nums[r] = tmp;

                r--;
            } else {
                cur++;
            }
        }
    }
}
