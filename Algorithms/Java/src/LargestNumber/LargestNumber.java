package src.LargestNumber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/2/8
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            list.add(String.valueOf(num));
        }
        list.sort((o1, o2) -> {
            String order1 = o1 + o2;
            String order2 = o2 + o1;
            return order2.compareTo(order1);
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (String number : list) {
            stringBuilder.append(number);
        }
        String string = stringBuilder.toString();
        if(string.charAt(0) == '0') {
            return "0";
        }
        return string;
    }
}
