package src.CountTheRepetitions;

public class CountTheRepetitions {

    /**
     * 暴力算一下，复杂度O(N * M)
     *
     * @param s1
     * @param n1
     * @param s2
     * @param n2
     * @return
     */
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int l1 = c1.length;
        int l2 = c2.length;
        int p = 0;
        int cnt = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < l1; j++) {
                if (c1[j] == c2[p]) {
                    if (++p == l2) {
                        p = 0;
                        cnt++;
                    }
                }
            }
        }
        return cnt / n2;
    }
}
