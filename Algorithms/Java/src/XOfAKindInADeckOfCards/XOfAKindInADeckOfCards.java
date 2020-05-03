package src.XOfAKindInADeckOfCards;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/3/27
 */
public class XOfAKindInADeckOfCards {

    /**
     * 求出多个累计数间的最大公约数
     *
     * @param deck
     * @return
     */
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int num : deck) {
            count[num]++;
        }
        return Arrays.stream(count).reduce(this::gcd).getAsInt() > 1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
