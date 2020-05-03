package src.ArrayTransformation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mingqiao
 * @Date 2020/3/2
 */
public class ArrayTransformation {

    /**
     * 模拟一下
     *
     * @param arr
     * @return
     */
    public List<Integer> transformArray(int[] arr) {
        int n = arr.length;
        boolean flag;
        do {
            flag = false;
            int tmp[] = Arrays.copyOf(arr, n);
            for (int i = 1; i < n - 1; i++) {
                if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    tmp[i]++;
                    flag = true;
                } else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    tmp[i]--;
                    flag = true;
                }
            }
            arr = tmp;
        } while (flag);
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }
}
