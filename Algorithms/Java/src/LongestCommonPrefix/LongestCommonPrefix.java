package src.LongestCommonPrefix;

/**
 * author: mingqiao
 * Date: 2018/9/6
 */

//题解：1.暴力解一下，算法复杂度最坏O(n * length)
//2.二分，算法复杂度最坏O(n * length * log(length))
//3.分治，看了题解才想起这个的。。算法复杂度O(lcp(s1,s2,...,sn))

public class LongestCommonPrefix {

    //算法一：暴力扫一下
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }

        int size = strs.length;
        for(int i = 0; i < strs[0].length(); i++) {
            char charAt = strs[0].charAt(i);
            for(int j = 1; j < size; j++) {
                if(strs[j].length() <= i || charAt != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    //算法二：二分一下
    public String longestCommonPrefix1(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }

        int minLength = strs[0].length();
        int size = strs.length;
        for(int i = 1; i < size; i++) {
            minLength = Math.min(minLength, strs[i].length());
        }

        int l = 1, r = minLength;
        while (l <= r) {
            int mid = (l + r) / 2;
            if(isOk(strs, mid)) {
                l++;
            } else {
                r--;
            }
        }
        return strs[0].substring(0, r);
    }

    //算法三：分治
    public String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }

        return divideAndConquer(strs, 0, strs.length - 1);
    }

    public String divideAndConquer(String[] strs, int l, int r) {
        if(l == r) {
            return strs[l];
        }

        int mid = (l + r) / 2;
        String lcpLeft = divideAndConquer(strs, l, mid);
        String lcpRight = divideAndConquer(strs, mid + 1, r);

        int len = Math.min(lcpLeft.length(), lcpRight.length());
        for(int i = 0; i < len; i++) {
            if(lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, len);
    }

    public Boolean isOk(String[] strs, int mid) {
        String string = strs[0].substring(0, mid);
        for(int i = 1; i < strs.length; i++) {
            if(!strs[i].startsWith(string)) {
                return false;
            }
        }
        return true;
    }


}
