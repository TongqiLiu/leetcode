package src.OddEvenLinkedList;

import src.A_Common_Package.ListNode;

/**
 * @author mingqiao
 * @Date 2020/3/19
 */
public class OddEvenLinkedList {

    /**
     * 按题意分出两个奇偶链表分别遍历下
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
