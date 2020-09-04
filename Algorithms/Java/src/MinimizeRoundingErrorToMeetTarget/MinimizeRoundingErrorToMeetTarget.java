package src.MinimizeRoundingErrorToMeetTarget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/9/4
 */
public class MinimizeRoundingErrorToMeetTarget {

    /**
     * 题目地址：https://leetcode-cn.com/problems/minimize-rounding-error-to-meet-target/
     * 贪心方案
     *
     * @param prices
     * @param target
     * @return
     */
    public String minimizeError(String[] prices, int target) {
        int n = prices.length;
        double[] arr = new double[n];
        int floorSum = 0, ceilSum = 0;
        for (int i = 0; i < n; i++) {
            double d = Double.valueOf(prices[i]);
            arr[i] = d;

            floorSum += (int)Math.floor(d);
            ceilSum += (int)Math.ceil(d);
        }
        if (floorSum > target || ceilSum < target) {
            return "-1";
        }
        int[] roundArr = roundUp(arr, target);
        double ans = 0.0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(roundArr[i] - arr[i]);
        }
        return String.format("%.3f", ans);
    }

    /**
     * 先将所有floor(x)加起来统计出如果所有都floor的话还差多少，按照ceil以后需要加的价格排序，贪心取最小的补齐
     *
     * @param arr
     * @return
     */
    public int[] roundUp(double[] arr, int sum) {
        int n = arr.length;
        int floorSum = 0;

        int[] ans = new int[n];
        List<Price> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            double price = arr[i];

            int floorPrice = (int)Math.floor(price);
            floorSum += floorPrice;
            list.add(new Price(price, floorPrice, i));

            ans[i] = floorPrice;
        }
        Collections.sort(list);

        int gap = sum - floorSum;
        for (int i = 0; i < gap; i++) {
            ans[list.get(i).index]++;
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    class Price implements Comparable<Price> {
        double originPrice;
        int floorPrice;
        int index;

        public Price(double originPrice, int floorPrice, int index) {
            this.originPrice = originPrice;
            this.floorPrice = floorPrice;
            this.index = index;
        }

        @Override
        public int compareTo(Price o) {
            return (originPrice - floorPrice) > (o.originPrice - o.floorPrice) ? -1 : 1;
        }
    }

    public static void main(String[] args) {
        String d[] = new String[] {"2.314", "2.008", "2.307", "2.390", "2.434", "2.355", "2.286", "2.297", "2.631", "2.582", "2.652", "2.663", "2.934", "2.166", "2.630", "2.358", "2.536", "2.676", "2.574", "2.325", "2.505", "2.510", "2.706", "2.890", "2.023", "2.901", "2.831", "2.426", "2.121", "2.417", "2.870", "2.037", "2.163", "2.928", "2.227", "2.895", "2.252", "2.029", "2.546", "2.442", "2.606", "2.174", "2.667", "2.715", "2.755", "2.970", "2.546", "2.302", "2.167", "2.459"};
        int dd[] = new int[] {2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 2, 3, 2, 3, 3, 3, 2, 2, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        double ans = 0.0;
        System.out.println(Arrays.stream(dd).sum());
        for (int i = 0; i < dd.length; i++) {
            ans += Math.abs(dd[i] - Double.valueOf(d[i]));
        }
        System.out.println(ans);
    }
}
