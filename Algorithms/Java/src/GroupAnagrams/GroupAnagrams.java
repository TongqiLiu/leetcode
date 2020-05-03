package src.GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * @author mingqiao
 * @Date 2019/12/25
 */
public class GroupAnagrams {

    /**
     * 排序分类下
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String newString = String.valueOf(chars);
            if (hashMap.containsKey(newString)) {
                List<String> list = hashMap.get(newString);
                list.add(strs[i]);
                hashMap.put(newString, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                hashMap.put(newString, list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (String key : hashMap.keySet()) {
            result.add(hashMap.get(key));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
