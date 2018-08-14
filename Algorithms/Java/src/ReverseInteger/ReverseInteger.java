package src.ReverseInteger;

/**
 * Created by tongqi on 2017/4/21.
 * Email: tongqicode@126.com
 */

//解题思路：模拟即可

public class ReverseInteger {

    public int reverse(int x) {
        long ans = 0;
        int flag = x > 0 ? 1 : -1;
        x = Math.abs(x);

        while(x != 0)
        {
            ans = ans * 10 + x % 10;
            x /= 10;
            if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)
                return 0;
        }
        return (int) ans * flag;
    }
}
