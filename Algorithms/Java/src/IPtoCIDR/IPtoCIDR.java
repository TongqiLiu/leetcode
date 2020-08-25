package src.IPtoCIDR;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/8/25
 */
public class IPtoCIDR {

    /**
     * 题目意思是将起点ip及其后面的n个ip给变成CIDR段的形式表示
     * 对于某个地址ip，寻找其最右边的1的位置。
     * 假设最右边1的位置的索引（从右往左）是k，那么这个长度为(32 - k)的ip地址能够代表(1 << k)个地址，
     * 因为最右边的1后面的0可以随意变换。
     *
     * @param ip
     * @param n
     * @return
     */
    public List<String> ipToCIDR(String ip, int n) {
        List<String> res = new ArrayList<>();
        long num = ipToLong(ip);
        int k = 0;
        while (num > 0 && (num & (1 << k)) == 0) {
            k++;
        }
        long count = (1 << k);
        if (n == count) {
            res.add(longToIp(num) + "/" + (32 - k));
            return res;
        } else if (n > count) {
            res.add(longToIp(num) + "/" + (32 - k));
            res.addAll(ipToCIDR(longToIp(num + count), n - (int)count));
            return res;
        }
        while ((1 << k) > n) {
            k--;
        }
        res.add(longToIp(num) + "/" + (32 - k));
        int remain = n - (1 << k);
        if (remain > 0) {
            res.addAll(ipToCIDR(longToIp(num + (1 << k)), remain));
        }
        return res;
    }

    private long ipToLong(String ip) {
        String[] strings = ip.split("\\.");
        long res = 0;
        for (int i = 0; i <= 3; i++) {
            res = res * 256 + Integer.parseInt(strings[i]);
        }
        return res;
    }

    private String longToIp(long num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num % 256);
        for (int i = 0; i < 3; i++) {
            num /= 256;
            sb.insert(0, ".");
            sb.insert(0, num % 256);
        }
        return sb.toString();
    }
}
