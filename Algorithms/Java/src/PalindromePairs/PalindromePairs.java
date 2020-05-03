package src.PalindromePairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mingqiao
 * @Date 2019/12/12
 */
public class PalindromePairs {

    private static List<List<Integer>> ans = new ArrayList<>();

    /**
     * 字符串反转构建字典树，再判定当前字符串在字典树中是否存在，如存在则证明存在其他串的子串镜像和该串相等，定义子串平均长度为k，则复杂度为O(N * K ^ 2)
     *
     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }

        ans = new ArrayList<>();
        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            find(root, words[i], i);
        }
        return ans;
    }

    private static class TrieNode {
        //当前字符串的数组位置，下游节点，以及能构成当前串or回文子串节点的数组位置集合
        int index;
        TrieNode[] next;
        List<Integer> palindIndex;

        public TrieNode() {
            index = -1;
            next = new TrieNode[26];
            palindIndex = new ArrayList<>();
        }
    }

    private static void addWord(TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int ch = word.charAt(i) - 'a';
            if (root.next[ch] == null) {
                root.next[ch] = new TrieNode();
            }

            if (isPalindrome(word, 0, i)) {
                root.palindIndex.add(index);
            }
            root = root.next[ch];
        }
        root.index = index;
        root.palindIndex.add(index);
    }

    private static void find(TrieNode root, String word, int index) {
        for (int i = 0; i < word.length(); i++) {
            //待匹配串比字典树子串长，如asadcc匹配树上的asad
            if (root.index != -1 && root.index != index && isPalindrome(word, i, word.length() - 1)) {
                ans.add(Arrays.asList(index, root.index));
            }
            if (root.next[word.charAt(i) - 'a'] == null) {
                return;
            }
            root = root.next[word.charAt(i) - 'a'];
        }
        //待匹配串比字典树子串短，如asad匹配树上的asadcc
        for (int i : root.palindIndex) {
            if (i != index) {
                ans.add(Arrays.asList(index, i));
            }
        }
    }

    private static boolean isPalindrome(String string, int l, int r) {
        while (l < r) {
            if (string.charAt(l++) != string.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
