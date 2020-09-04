package src.KokoEatingBananas;

/**
 * @author mingqiao
 * @Date 2020/9/4
 */
public class KokoEatingBananas {

    /**
     * 最小化最大值问题，二分解决
     *
     * @param piles
     * @param H
     * @return
     */
    public int minEatingSpeed(int[] piles, int H) {
        int l = 0, r = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;

            if (canEat(piles, H, mid)) {
                ans = Math.min(ans, mid);
                r = mid;
            } else {
                l = mid;
            }
        }
        if (canEat(piles, H, r)) {
            ans = canEat(piles, H, l) ? Math.min(ans, l) : Math.min(ans, r);
        }
        return ans;
    }

    private boolean canEat(int[] piles, int H, int speed) {
        if (speed <= 0) {
            return false;
        }
        int cnt = 0;
        for (int pile : piles) {
            cnt += pile / speed;
            if (pile % speed != 0) {
                cnt++;
            }
        }
        return cnt <= H;
    }
}
