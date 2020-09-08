package src.SmallestCommonRegion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mingqiao
 * @Date 2020/9/8
 */
public class SmallestCommonRegion {

    /**
     * 类似LCA解法，复杂度O(N ^ 2)
     *
     * @param regions
     * @param region1
     * @param region2
     * @return
     */
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        if (null == regions || regions.size() == 0) {
            return null;
        }
        //建立父节点的map
        Map<String, String> map = new HashMap<>();
        for (List<String> regionList : regions) {
            String parentRegion = regionList.get(0);
            for (int i = 1; i < regionList.size(); i++) {
                map.put(regionList.get(i), parentRegion);
            }
        }
        List<String> list = find(region1, map);
        List<String> list2 = find(region2, map);
        for (String p : list) {
            if (list2.contains(p)) {
                return p;
            }
        }
        return "";
    }

    private List<String> find(String region, Map<String, String> map) {
        String parent1 = region;
        List<String> list = new ArrayList<>();
        while (parent1 != null) {
            list.add(parent1);
            parent1 = map.get(parent1);
        }
        return list;
    }
}
