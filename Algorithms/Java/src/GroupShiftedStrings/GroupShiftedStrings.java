package src.GroupShiftedStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mingqiao
 * @Date 2020/3/6
 */
public class GroupShiftedStrings {

    /**
     * 计算每个字符串距离它们首位置字母差的hash值
     *
     * @param strings
     * @return
     */
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new ArrayList<>();
        if (strings == null || strings.length == 0) {
            return ans;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            StringBuilder sb = new StringBuilder();
            for (char c : str.toCharArray()) {
                //这里统一加26保证差值的循环，通过-避免两个个位和一个十位数值差的hash碰撞
                int hash = (c - str.charAt(0) + 26) % 26;
                sb.append(hash);
                sb.append("-");
            }
            map.merge(sb.toString(), new ArrayList<String>() {{
                    add(str);
                }},
                (pre, one) -> {
                    pre.addAll(one);
                    return pre;
                }
            );
        }
        ans = new ArrayList<>(map.values());
        return ans;
    }
}
