package src.LinkedListCycleII;

import src.A_Common_Package.ListNode;

/**
 * @author mingqiao
 * @Date 2020/3/9
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return new ListNode(-1);
        }

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return new ListNode(-1);
    }
}
