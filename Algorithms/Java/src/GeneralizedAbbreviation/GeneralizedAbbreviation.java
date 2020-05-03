package src.GeneralizedAbbreviation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2020/3/6
 */
public class GeneralizedAbbreviation {

    /**
     * 长度为n的字符串，每个位置有不/缩写两种可能性，故存在2^n个缩写表示
     * 我们定义字符串每个位置缩写则二进制表示为1，未缩写表示为0，比如"word"表示成"0011"表示为"wo2"
     * 时间复杂度O(N * 2 ^ N)
     *
     * @param word
     * @return
     */
    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();
        if (word == null) {
            return ans;
        }

        int n = word.length();
        for (int i = 0; i < (1 << n); i++) {
            StringBuilder sb = new StringBuilder();
            int number = 0;

            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) != 0) {
                    number++;
                } else {
                    if (number != 0) {
                        sb.append(number);
                        number = 0;
                    }
                    sb.append(word.charAt(j));
                }
            }
            if (number != 0) {
                sb.append(number);
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
