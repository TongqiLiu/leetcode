package src.ShortestWordDistanceIII;

/**
 * @author mingqiao
 * @Date 2020/3/2
 */
public class ShortestWordDistanceIII {

    /**
     * 类似的思路，保证两单词相同时只更新前一次就行
     *
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1;
        int ans = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                p1 = i;

                if (p2 >= 0) {
                    ans = Math.min(ans, Math.abs(p1 - p2));
                }
            }
            if (words[i].equals(word2)) {
                p2 = i;

                if (p1 >= 0 && p1 != p2) {
                    ans = Math.min(ans, Math.abs(p1 - p2));
                }
            }
        }
        return ans;
    }
}
