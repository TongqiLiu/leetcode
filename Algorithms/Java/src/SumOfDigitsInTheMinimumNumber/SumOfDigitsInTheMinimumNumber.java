package src.SumOfDigitsInTheMinimumNumber;

/**
 * @author mingqiao
 * @Date 2020/2/29
 */
public class SumOfDigitsInTheMinimumNumber {

    public int sumOfDigits(int[] A) {
        int min = Integer.MAX_VALUE, ans = 0;
        for (int i = 0; i < A.length; i++) {
            min = A[i] < min ? A[i] : min;
        }
        while (min != 0) {
            ans += min % 10;
            min /= 10;
        }
        return ans % 2 == 1 ? 0 : 1;
    }
}
