package src.HouseRobberIII;

import java.util.HashMap;
import java.util.Map;

import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/2/21
 */
public class HouseRobberIII {

    private Map<TreeNode, Integer> robMap = new HashMap<>();
    private Map<TreeNode, Integer> noRobMap = new HashMap<>();

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (robMap.containsKey(root) && noRobMap.containsKey(root)) {
            return Math.max(robMap.get(root), robMap.get(root));
        }

        dfs(root.left);
        dfs(root.right);

        int rob = root.val;
        if (noRobMap.containsKey(root.left)) {
            rob += noRobMap.get(root.left);
        }
        if (noRobMap.containsKey(root.right)) {
            rob += noRobMap.get(root.right);
        }
        robMap.put(root, rob);

        int noRob = 0;
        //注意一下这里当前节点不抢，则可以从上个节点抢及不抢两种可能性转移过来
        if (robMap.containsKey(root.left)) {
            noRob += Math.max(robMap.get(root.left), noRobMap.get(root.left));
        }
        if (robMap.containsKey(root.right)) {
            noRob += Math.max(robMap.get(root.right), noRobMap.get(root.right));
        }
        noRobMap.put(root, noRob);
        return Math.max(rob, noRob);
    }

    /**
     * 根据当前节点抢与不抢有两种转移的可能性，分开讨论即可
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        robMap = new HashMap<>();
        noRobMap = new HashMap<>();
        return dfs(root);
    }
}
