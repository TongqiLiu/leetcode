package src.ExcelSheetColumnNumber;

/**
 * @author mingqiao
 * @Date 2020/3/19
 */
public class ExcelSheetColumnNumber {

    /**
     * 字符串转26进制
     *
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        char[] charArray = s.toCharArray();
        int res = 0;
        for (int i = 0; i < charArray.length; i++) {
            res = res * 26 + (charArray[i] - 'A' + 1);
        }
        return res;
    }
}
