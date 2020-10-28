package src.PartitionList;

import src.A_Common_Package.ListNode;

/**
 * @author mingqiao
 * @Date 2020/10/26
 */
public class PartitionList {

    /**
     * 题目地址：https://leetcode-cn.com/problems/partition-list/
     * 虚拟链表头模拟即可
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(-1), newMiddle = new ListNode(-1);
        ListNode p = newHead, q = newMiddle;
        while (head != null) {
            if (head.val < x) {
                newHead.next = new ListNode(head.val);
                newHead = newHead.next;
            } else {
                newMiddle.next = new ListNode(head.val);
                newMiddle = newMiddle.next;
            }
            head = head.next;
        }
        if (q.next != null) {
            newHead.next = q.next;
        }
        return p.next;
    }
}
