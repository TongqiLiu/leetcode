package src.ReverseNodesInkGroup;

/**
 * author: mingqiao
 * Date: 2018/12/14
 */

//题解：每K个为一组，组内反转链表，组间使用递归来连接，复杂度O(N)
public class ReverseNodesInkGroup {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode preNode = null;

        while (head != tail) {
            ListNode nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }
        return preNode;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode curNode = head;
        for (int i = 0; i < k; i++) {
            if (curNode == null) {
                return head;
            }
            curNode = curNode.next;
        }

        ListNode reverseHead = reverse(head, curNode);
        head.next = reverseKGroup(curNode, k);
        return reverseHead;
    }
}
