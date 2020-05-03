package src.ShortestWordDistance;

/**
 * @author mingqiao
 * @Date 2020/3/2
 */
public class ShortestWordDistance {

    /**
     * 向右遍历，维护最小距离值，复杂度O(N)
     *
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1;
        int ans = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                p1 = i;
            }
            if (words[i].equals(word2)) {
                p2 = i;
            }

            if (p1 != -1 && p2 != -1) {
                ans = Math.min(ans, Math.abs(p1 - p2));
            }
        }
        return ans;
    }
}
