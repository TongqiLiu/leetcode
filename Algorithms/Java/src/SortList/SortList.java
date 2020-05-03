package src.SortList;

import src.A_Common_Package.ListNode;

/**
 * @author mingqiao
 * @Date 2020/2/5
 */
public class SortList {

    /**
     * 归并排序，分治解决复杂度O(N * logN)，快慢指针可以方便地找出中间节点
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        ListNode preNode = new ListNode(-1);
        ListNode tmp = preNode;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                tmp.next = left;
                left = left.next;
            } else {
                tmp.next = right;
                right = right.next;
            }
            tmp = tmp.next;
        }
        tmp.next = left != null ? left : right;
        return preNode.next;
    }
}
