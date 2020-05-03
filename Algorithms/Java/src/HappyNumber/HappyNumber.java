package src.HappyNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mingqiao
 * @Date 2020/2/8
 */
public class HappyNumber {

    /**
     * 快慢指针解决也可以
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            n = cal(n);
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }

    public int cal(int n) {
        int sum = 0;
        int num;
        while (n != 0) {
            num = n % 10;
            n /= 10;
            sum += num * num;
        }
        return sum;
    }

}
