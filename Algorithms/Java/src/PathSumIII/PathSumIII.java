package src.PathSumIII;

import java.util.ArrayList;
import java.util.List;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/3/2
 */
public class PathSumIII {

    private int ans = 0;

    /**
     * 保存路径，反向累计和计算
     *
     * @param root
     * @param curList
     * @param sum
     */
    private void dfs(TreeNode root, List<Integer> curList, int sum) {
        if (root == null) {
            return;
        }

        int tmp = root.val;
        int count = tmp == sum ? 1 : 0;
        for (int i = curList.size() - 1; i >= 0; i--) {
            tmp += curList.get(i);
            if (tmp == sum) {
                count++;
            }
        }
        curList.add(root.val);
        ans += count;

        dfs(root.left, curList, sum);
        dfs(root.right, curList, sum);
        curList.remove(curList.size() - 1);
    }

    public int pathSum(TreeNode root, int sum) {
        ans = 0;
        dfs(root, new ArrayList<>(), sum);
        return ans;
    }
}
