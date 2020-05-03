package src.FractionToRecurringDecimal;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author mingqiao
 * @Date 2020/3/23
 */
public class FractionToRecurringDecimal {

    /**
     * 模拟下运算
     *
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        long num = numerator;
        long den = denominator;
        String sign = "";
        if (num > 0 && den < 0 || num < 0 && den > 0) {
            sign = "-";
        }
        num = Math.abs(num);
        den = Math.abs(den);

        //计算整数部分及余数
        long integer = num / den;
        num = num - integer * den;

        HashMap<Long, Integer> map = new HashMap<>();
        int index = 0;
        //记录小数部分
        StringBuilder decimal = new StringBuilder();
        int repeatIndex = -1;
        while (num != 0) {
            num *= 10;
            //出现了循环节
            if (map.containsKey(num)) {
                repeatIndex = map.get(num);
                break;
            }
            map.put(num, index);

            //当前的商
            long decimalPlace = num / den;
            decimal.append(decimalPlace);

            //计算新的余数
            num = num - decimalPlace * den;
            index++;
        }
        if (repeatIndex != -1) {
            return sign + integer + "." + decimal.substring(0, repeatIndex) + "(" + decimal.substring(repeatIndex) + ")";
        } else {
            if (decimal.length() == 0) {
                return sign + integer;
            } else {
                return sign + integer + "." + decimal;
            }
        }
    }
}
