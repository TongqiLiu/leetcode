package src.ReverseLinkedList;

/**
 * author: mingqiao
 * Date: 2019/1/23
 */

//题解：直接模拟
public class ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;

        while (head != null) {
            ListNode nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }
        return preNode;
    }
}
