package src.A_Common_Package;

/**
 * @author mingqiao
 * @Date 2020/1/14
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
            "val=" + val +
            ", left=" + left +
            ", right=" + right +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof TreeNode)) { return false; }

        TreeNode treeNode = (TreeNode)o;

        if (val != treeNode.val) { return false; }
        if (!left.equals(treeNode.left)) { return false; }
        return right.equals(treeNode.right);
    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + left.hashCode();
        result = 31 * result + right.hashCode();
        return result;
    }
}
