package src.LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * author: mingqiao
 * Date: 2018/11/28
 */

//题解：dfs回溯下就行
public class LetterCombinationsOfAPhoneNumber {

    private static final String[] LETTERS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private List<String> list = new ArrayList<>();

    public void dfs(String now, int index, String digits) {
        if(index == digits.length()) {
            list.add(now);
            return ;
        }

        String string = LETTERS[digits.charAt(index) - '0'];
        for(int i = 0; i < string.length(); i++) {
            dfs(now + string.charAt(i), index + 1, digits);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return list;
        }

        dfs("", 0, digits);
        return list;
    }
}
