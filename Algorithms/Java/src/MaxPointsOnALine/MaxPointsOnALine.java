package src.MaxPointsOnALine;

import java.util.Map;

/**
 * @author mingqiao
 * @Date 2020/2/4
 */
public class MaxPointsOnALine {

    /**
     * 看了下题解，O(n ^ 3)方的暴力...
     *
     * @param points
     * @return
     */
    public static int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }

        int maxp = 2;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int temp = 0;
                long x1 = points[i][0], y1 = points[i][1];
                long x2 = points[j][0], y2 = points[j][1];
                if (x1 == x2 && y1 == y2) {
                    x2++;
                    y2++;
                }
                for (int k = 0; k < points.length; k++) {
                    long x = points[k][0];
                    long y = points[k][1];
                    if (((y - y1) * (x2 - x1) == (x - x1) * (y2 - y1))) {
                        temp++;
                    }
                }
                maxp = Math.max(maxp, temp);
            }
        }
        return maxp;
    }

    public static void main(String[] args) {
        maxPoints(new int[][] {{0, 0}, {1, 65536}, {65536, 0}});
        maxPoints(new int[][] {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}});
    }
}
