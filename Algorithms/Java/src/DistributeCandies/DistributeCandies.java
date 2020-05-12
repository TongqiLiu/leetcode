package src.DistributeCandies;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

    /**
     * 种类和数量/2取min
     *
     * @param candies
     * @return
     */
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int num : candies) {
            set.add(num);
        }
        return Math.min(candies.length / 2, set.size());
    }
}
