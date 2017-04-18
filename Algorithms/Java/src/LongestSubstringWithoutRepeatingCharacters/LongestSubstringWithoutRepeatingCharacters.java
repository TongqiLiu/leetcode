import java.util.HashMap;

/**
 * Created by tongqi on 2017/4/18.
 * Email: tongqicode@126.com
 */

//����˼·��˫ָ��ȥ��¼������ģ����Ӵ�����β��ע���жϵ�ǰ�ַ������������ϸ�ģ����Ӵ����ǵ�����ģ����Ӵ������Ӷ�O(N)

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        int l = 0, r = 0, ans = 0, len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!hashMap.containsKey(s.charAt(i)) || hashMap.get(s.charAt(i)) < l) {
                r++;
                len++;
                hashMap.put(s.charAt(i), i);
                ans = Math.max(ans, len);
            } else {
                ans = Math.max(len, ans);
                l = hashMap.get(s.charAt(i)) + 1;
                len = r - l + 1;

                r++;
                hashMap.put(s.charAt(i), i);
            }
        }
        return ans;
    }
}
