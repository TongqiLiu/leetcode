package src.A_Common_Package;

/**
 * @author mingqiao
 * @Date 2020/3/20
 */
public class TreeNode1 {
    public int val;
    public TreeNode1 left;
    public TreeNode1 right;
    public TreeNode1 next;

    public TreeNode1() {}

    public TreeNode1(int _val) {
        val = _val;
    }

    public TreeNode1(int _val, TreeNode1 _left, TreeNode1 _right, TreeNode1 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
