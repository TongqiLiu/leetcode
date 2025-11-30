package src.RansomNote;

/**
 * @author tongqi
 * @date 2025/11/30
 */
public class RansomNote {

    /**
     * 判断ransomNote是否能由magazine中的字符构成
     * 
     * @param ransomNote 勒索信字符串
     * @param magazine 杂志字符串
     * @return 如果ransomNote能由magazine中的字符构成返回true，否则返回false
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) {
            return false;
        }
        if (ransomNote.isEmpty()) {
            return true;
        }
        int[] count = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            count[ransomNote.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] < 0) {
                return false;
            }
        }
        return true;
    }
}

