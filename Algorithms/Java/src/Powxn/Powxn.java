package src.Powxn;

/**
 * @author mingqiao
 * @Date 2019/12/25
 */
public class Powxn {

    double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double half = myPow(x, n / 2);
        double remain = myPow(x, n % 2);
        return half * half * remain;
    }

    public static void main(String[] args) {
        System.out.println(Double.valueOf("5.0").intValue());
    }
}