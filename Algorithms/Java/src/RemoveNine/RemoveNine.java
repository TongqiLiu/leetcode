package src.RemoveNine;

/**
 * @author mingqiao
 * @Date 2020/3/2
 */
public class RemoveNine {

    /**
     * 9进制表示该数
     *
     * @param n
     * @return
     */
    public int newInteger(int n) {
        StringBuilder a = new StringBuilder();
        while (n > 0) {
            int mod = n % 9;
            a.insert(0, mod);
            n = n / 9;
        }
        return Integer.valueOf(a.toString());
    }
}
