package src.MinimumNumberOfArrowsToBurstBalloons;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mingqiao
 * @Date 2020/2/4
 */
public class MinimumNumberOfArrowsToBurstBalloons {

    /**
     * 贪心原则：如果后一个区间的起始点小于等于上个区间的结束点，则视为重叠，不增加箭数量
     *
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int ans = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                continue;
            }

            ans += 1;
            end = points[i][1];
        }
        return ans;
    }
}
