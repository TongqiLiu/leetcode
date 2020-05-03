package src.EvaluateDivision;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * @author mingqiao
 * @Date 2020/2/8
 */
public class EvaluateDivision {

    private class UnionSet {

        private HashMap<String, String> fathers;
        private HashMap<String, Double> values;

        public UnionSet() {
            fathers = new HashMap<>();
            values = new HashMap<>();
        }

        public String find(String s) {
            if (s.equals(fathers.get(s))) {
                return s;
            } else {
                //路径压缩及权值累计
                String root = find(fathers.get(s));
                values.put(s, values.get(s) * values.get(fathers.get(s)));
                return fathers.put(s, root);
            }
        }

        public void union(String x, String y, Double v) {
            if (!fathers.containsKey(x)) {
                fathers.put(x, x);
                values.put(x, 1.0);
            }
            if (!fathers.containsKey(y)) {
                fathers.put(y, y);
                values.put(y, 1.0);
            }

            String fx = find(x), fy = find(y);
            if (fx.equals(fy)) {
                return;
            }

            //两集合合并
            fathers.put(fy, fx);
            values.put(fy, values.get(x) * v / values.get(y));
        }

        public Double query(String x, String y) {
            if (!fathers.containsKey(x) || !fathers.containsKey(y)) {
                return -1.0;
            }
            String fx = find(x);
            String fy = find(y);
            if (!fx.equals(fy)) {
                return -1.0;
            }

            return values.get(y) / values.get(x);
        }
    }

    /**
     * 使用并查集完成集合与集合间的合并
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionSet unionSet = new UnionSet();
        for (int i = 0; i < equations.size(); i++) {
            List<String> list = equations.get(i);
            String a = list.get(0);
            String b = list.get(1);

            unionSet.union(a, b, values[i]);
        }

        //所有Union完成后，需要对集合元素进行一次路径压缩保证每个节点到根节点的计算提前完成
        for (Entry<String, String> entry : unionSet.fathers.entrySet()) {
            String key = entry.getKey();
            unionSet.find(key);
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> list = queries.get(i);
            String a = list.get(0);
            String b = list.get(1);

            ans[i] = unionSet.query(a, b);
        }
        return ans;
    }
}
