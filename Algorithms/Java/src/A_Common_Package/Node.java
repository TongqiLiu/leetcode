package src.A_Common_Package;

/**
 * @author mingqiao
 * @Date 2020/3/18
 */
public class Node {

    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Node)) { return false; }

        Node node = (Node)o;

        if (val != node.val) { return false; }
        if (next != null ? !next.equals(node.next) : node.next != null) { return false; }
        return random != null ? random.equals(node.random) : node.random == null;
    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        result = 31 * result + (random != null ? random.hashCode() : 0);
        return result;
    }
}
