package src.OptimalAccountBalancing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author mingqiao
 * @Date 2020/2/16
 */
public class OptimalAccountBalancing {

    private static int ans = Integer.MAX_VALUE;

    public static void dfs(ArrayList<Integer> depts, int start, int count) {
        while (start < depts.size() && depts.get(start) == 0) {
            start++;
        }
        if (count >= ans) {
            return;
        }
        if (start == depts.size()) {
            ans = Math.min(ans, count);
            return;
        }
        for (int i = start + 1; i < depts.size(); i++) {
            if (depts.get(start) < 0 && depts.get(i) > 0
                || depts.get(start) > 0 && depts.get(i) < 0) {
                depts.set(i, depts.get(i) + depts.get(start));
                dfs(depts, start + 1, count + 1);
                depts.set(i, depts.get(i) - depts.get(start));
            }
        }
    }

    /**
     * 遍历出来每个人的账单，然后dfs搜索枚举每个人的账号和其他人账单搜索归并，看能否达到收支平衡
     *
     * @param transactions
     * @return
     */
    public static int minTransfers(int[][] transactions) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] transaction : transactions) {
            map.put(transaction[0], map.getOrDefault(transaction[0], 0) - transaction[2]);
            map.put(transaction[1], map.getOrDefault(transaction[1], 0) + transaction[2]);
        }
        //为0表示该用户可以通过借、还相互低消
        ArrayList<Integer> depts = new ArrayList<>();
        for (int dept : map.values()) {
            if (dept != 0) {
                depts.add(dept);
            }
        }
        dfs(depts, 0, 0);
        return ans;
    }

    public static void main(String[] args) {
        minTransfers(new int[][] {{0, 1, 10}, {1, 0, 1}, {1, 2, 5}, {2, 0, 5}});
    }
}
