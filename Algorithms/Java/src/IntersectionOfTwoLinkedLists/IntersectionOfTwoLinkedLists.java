package src.IntersectionOfTwoLinkedLists;

import src.A_Common_Package.ListNode;

/**
 * @author mingqiao
 * @Date 2020/2/27
 */
public class IntersectionOfTwoLinkedLists {

    /**
     * 两个链表分开遍历，一方一旦到终点就连在另一方起点上，这样就消除了链表长度差
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
