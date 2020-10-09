package src.SentenceScreenFitting;

/**
 * @author mingqiao
 * @Date 2020/10/9
 */
public class SentenceScreenFitting {

    /**
     * 题目链接：https://leetcode-cn.com/problems/sentence-screen-fitting/
     * 模拟题，复杂度O(N)
     *
     * @param sentence
     * @param rows
     * @param cols
     * @return
     */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length;
        int ans = 0, singleRowLeft = cols;

        //当前所在单词的索引及行索引
        int wordIndex = 0, rowIndex = 0;
        while (rowIndex < rows) {
            int len = sentence[wordIndex].length();
            if (singleRowLeft >= len) {
                singleRowLeft = singleRowLeft - len - 1;
                wordIndex++;
                //放完了一个句子
                if (wordIndex == n) {
                    ans++;
                    wordIndex = 0;
                }
            } else {
                //空间放不下一个单词
                rowIndex++;
                singleRowLeft = cols;
            }
        }
        return ans;
    }
}
