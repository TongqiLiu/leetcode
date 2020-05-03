package src.DietPlanPerformance;

/**
 * @author mingqiao
 * @Date 2020/2/24
 */
public class DietPlanPerformance {

    /**
     * 简单维护下前缀和即可
     *
     * @param calories
     * @param k
     * @param lower
     * @param upper
     * @return
     */
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        if (calories == null || calories.length == 0) {
            return 0;
        }
        int n = calories.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + calories[i];
        }

        int ans = 0;
        for (int i = 1; i <= n - k + 1; i++) {
            if (sum[i + k - 1] - sum[i - 1] > upper) {
                ans++;
            }
            if (sum[i + k - 1] - sum[i - 1] < lower) {
                ans--;
            }
        }
        return ans;
    }
}
