package src.MergeTwoSortedLists;

/**
 * author: mingqiao
 * Date: 2018/12/5
 */
//题解：直接合并下就行
public class MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode firstNode = new ListNode(-1);
        ListNode resultNode = firstNode;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                resultNode.next = l1;
                l1 = l1.next;
            } else {
                resultNode.next = l2;
                l2 = l2.next;
            }
            resultNode = resultNode.next;
        }
        if (l1 != null) {
            resultNode.next = l1;
        } else {
            resultNode.next = l2;
        }
        return firstNode.next;
    }
}
