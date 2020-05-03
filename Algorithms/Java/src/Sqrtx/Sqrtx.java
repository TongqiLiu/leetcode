package src.Sqrtx;

/**
 * @author mingqiao
 * @Date 2020/1/1
 */
public class Sqrtx {

    /**
     * 注意下二分的边界
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long l = 0, r = x, ans = 0;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long square = mid * mid;
            if (square == x) {
                ans = mid;
                break;
            }
            if (square < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (ans > 0) {
            return (int)ans;
        }
        return (int)r;
    }
}
