package src.DistributeCandiesToPeople;

/**
 * @author mingqiao
 * @Date 2020/3/5
 */
public class DistributeCandiesToPeople {

    public int[] distributeCandies(int candies, int num_people) {
        int cnt = 0;

        int[] res = new int[num_people];
        while (candies > 0) {
            res[cnt % num_people] += Math.min(cnt++, candies);
            candies -= cnt;
        }
        return res;
    }
}
