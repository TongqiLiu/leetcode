package src.BestMeetingPoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mingqiao
 * @Date 2020/3/9
 */
public class BestMeetingPoint {

    /**
     * 从曼哈顿公式我们可以发现(x,y)两维是可以拆解到两个一维数组处理，然后取中位数：
     * 当目标点左边和右边有相同数目的点，总距离最小，因为一旦左移或者右移势必有一方距离要(位移偏移)*2
     *
     * @param grid
     * @return
     */
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }
        int x = rows.get(rows.size() / 2);
        cols.sort(Comparator.comparingInt(o -> o));
        int y = cols.get(cols.size() / 2);
        return getDis(rows, x) + getDis(cols, y);
    }

    private int getDis(List<Integer> points, int medium) {
        int dis = 0;
        for (int point : points) {
            dis += Math.abs(point - medium);
        }
        return dis;
    }
}
