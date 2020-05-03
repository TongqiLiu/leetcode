package src.VerifyPostorder;

import java.util.Stack;

/**
 * @author mingqiao
 * @Date 2020/3/26
 */
public class VerifyPostorder {

    /**
     * 地址：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
     * 遍历后序遍历的[i, j]区间元素，寻找第一个大于根节点的节点m，由它可划分出左子树区间[i, m-1]，右子树区间[m, j-1]，根节点为j，复杂度O(N ^ 2)
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return dfs(postorder, 0, postorder.length - 1);
    }

    private boolean dfs(int[] po, int i, int j) {
        if (i >= j) {
            return true;
        }

        int l = i;
        while (po[l] < po[j]) {
            l++;
        }
        int m = l;
        while (po[l] > po[j]) {
            l++;
        }
        return l == j && dfs(po, i, m - 1) && dfs(po, m, j - 1);
    }

    /**
     * 单调栈解法：反向来看，数组应满足"根、右、左"的顺序，故维护单调递增栈，遇到比栈顶大的元素就入栈(右子树)，遇到小的就出栈(左子树)
     *
     * @param postorder
     * @return
     */
    private boolean verifyPostorder1(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }

        int n = postorder.length;
        Stack<Integer> stack = new Stack<>();

        //虚拟一个"根"节点保证第一轮正确性
        int root = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }

            stack.add(postorder[i]);
        }
        return true;
    }
}
