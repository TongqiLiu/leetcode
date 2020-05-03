package src.GasStation;

/**
 * @author mingqiao
 * @Date 2020/3/18
 */
public class GasStation {

    /**
     * 贪心思路：肯定优先从补充gas[i] - cost[i]剩余油量多的地方出发
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remain = 0, sum = 0, start = 0;
        for (int i = 0; i < gas.length; ++i) {
            remain += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        return (remain < 0) ? -1 : start;
    }
}
