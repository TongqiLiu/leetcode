package src.LinkedListCycle;

import src.A_Common_Package.ListNode;

/**
 * @author mingqiao
 * @Date 2020/2/7
 */
public class LinkedListCycle {

    /**
     * 经典问题了，快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
