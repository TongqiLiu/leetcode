package src.InsertInterval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2019/12/20
 */
public class InsertInterval {

    /**
     * 模拟题，需要注意线段顺序和边界限制
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if ((intervals == null || intervals.length == 0)) {
            int[][] ans = new int[1][];
            if (newInterval != null) {
                ans[0] = newInterval;
            }
            return ans;
        }
        if (newInterval == null || newInterval.length == 0) {
            return intervals;
        }

        List<int[]> list = new ArrayList<>();
        int l = newInterval[0], r = newInterval[1], len = 0;

        boolean flag = false;
        for (int i = 0; i < intervals.length; i++) {
            int[] segment = intervals[i];
            int sl = segment[0], sr = segment[1];

            if (sl > r || sr < l) {
                list.add(segment);
                if(sl <= l && sr >= r) {
                    flag = true;
                }
            } else {
                int ml = l, mr = r;
                flag = true;
                System.out.println("ml:" + ml + ", mr:" + mr);
                while (sr >= ml && sl <= mr) {
                    ml = Math.min(ml, sl);
                    mr = Math.max(mr, sr);

                    i++;
                    if(i >= intervals.length) {
                        break;
                    }
                    segment = intervals[i];
                    sl = segment[0];
                    sr = segment[1];
                }
                list.add(new int[] {ml, mr});
                if(i < intervals.length) {
                    list.add(new int[] {sl, sr});
                }
            }
        }
        if(!flag) {
            list.add(newInterval);
        }
        list.sort((o1, o2) -> {
            int o1l = o1[0], o1r = o1[1];
            int o2l = o2[0], o2r = o2[1];
            if (o1l != o2l) {
                return o1l - o2l;
            } else {
                return o1r - o2r;
            }

        });

        int[][] ans = new int[list.size()][];
        for (int[] v : list) {
            ans[len++] = v;
        }
        return ans;
    }
}
