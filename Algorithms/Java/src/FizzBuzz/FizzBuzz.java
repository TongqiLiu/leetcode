package src.FizzBuzz;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/3/21
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> li = new ArrayList<>();
        for (Integer i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                li.add("FizzBuzz");
            } else if (i % 3 == 0) {
                li.add("Fizz");
            } else if (i % 5 == 0) {
                li.add("Buzz");
            } else {
                li.add(i.toString());
            }
        }
        return li;
    }
}
