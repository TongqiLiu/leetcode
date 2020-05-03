package src.MiddleOfTheLinkedList;

import src.A_Common_Package.ListNode;

/**
 * @author mingqiao
 * @Date 2020/3/23
 */
public class MiddleOfTheLinkedList {

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
