package src.RotateList;

/**
 * @author mingqiao
 * @Date 2019/12/30
 */
public class RotateList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    /**
     * 模拟一下，先找到尾部接到头部，再剪开第n - k那个节点的链接
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) { return null; }
        if (head.next == null) { return head; }

        ListNode lastNode = head;
        int n;
        for (n = 1; lastNode.next != null; n++) {
            lastNode = lastNode.next;
        }
        lastNode.next = head;

        ListNode tailNode = head;
        k = k % n;
        for (int i = 0; i < n - k - 1; i++) {
            tailNode = tailNode.next;
        }
        ListNode newHeadNode = tailNode.next;
        tailNode.next = null;
        return newHeadNode;
    }
}
