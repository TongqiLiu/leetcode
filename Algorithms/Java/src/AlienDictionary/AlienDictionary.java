package src.AlienDictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

/**
 * @author mingqiao
 * @Date 2020/2/3
 */
public class AlienDictionary {

    public class TopoSort {

        private int cnt;
        private int[] head;
        private int[] in;
        private int[] dep;
        private Edge[] edges;

        public class Edge {
            private int to, nxt;

            Edge(int to, int nxt) {
                this.to = to;
                this.nxt = nxt;
            }

            @Override
            public String toString() {
                return "Edge{" +
                    "to=" + to +
                    ", nxt=" + nxt +
                    '}';
            }
        }

        public void addEdge(int u, int v) {
            edges[cnt] = new Edge(v, head[u]);
            head[u] = cnt++;
            in[v]++;
        }

        public TopoSort(int n) {
            cnt = 0;
            head = new int[n];
            Arrays.fill(head, -1);
            in = new int[n];
            Arrays.fill(in, 0);
            dep = new int[n];
            Arrays.fill(dep, 0);
            edges = new Edge[n * n];
        }

        public boolean sort(int n) {
            int tot = 0;
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (in[i] == 0) {
                    dep[i] = 0;
                    queue.offer(i);
                    tot++;
                }
            }

            while (!queue.isEmpty()) {
                int u = queue.poll();

                for (int i = head[u]; i != -1; i = edges[i].nxt) {
                    int v = edges[i].to;
                    --in[v];

                    if (in[v] == 0) {
                        tot++;
                        queue.offer(v);
                        dep[v] = dep[u] + 1;
                    }
                }
            }
            return tot == n;
        }
    }

    /**
     * 字典序可以通过图建边的方式展现，如果某字母字典序比另一字母小则加一条边，然后跑拓扑排序无环则表示为出现顺序矛盾
     * ，注意这题会存在一些未排序的节点也需要加进去，且如果存在多个子图未联通的情况下，多个子图间需要合并只需保证子图
     * 内部拓扑顺序正常即可
     * @param words
     * @return
     */
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> idMap = new HashMap<>();
        Map<Integer, Character> charMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                set.add(words[i].charAt(j));
            }
        }
        int nums = 0;
        for (Character ch : set) {
            idMap.put(ch, nums);
            charMap.put(nums++, ch);
        }
        TopoSort topoSort = new TopoSort(nums);

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length() && j < words[i + 1].length(); j++) {
                //如果字符相同，比较下一个
                if (words[i].charAt(j) == words[i + 1].charAt(j)) {
                    continue;
                }

                int u = idMap.get(words[i].charAt(j)), v = idMap.get(words[i + 1].charAt(j));
                topoSort.addEdge(u, v);
                break;
            }
        }

        if (!topoSort.sort(nums)) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Map<Integer, Character> depMap = new IdentityHashMap<>();
        int[] dep = topoSort.dep;
        for (int i = 0; i < dep.length; i++) {
            Character ch = charMap.get(i);
            depMap.put(dep[i], ch);
        }
        List<Entry<Integer, Character>> list = new ArrayList<>(depMap.entrySet());
        list.sort(Comparator.comparing(Entry::getKey));
        for (Map.Entry<Integer, Character> entry : list) {
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        System.out.println(alienDictionary.alienOrder(new String[] {"ab", "ac", "de", "df"}));

    }
}
