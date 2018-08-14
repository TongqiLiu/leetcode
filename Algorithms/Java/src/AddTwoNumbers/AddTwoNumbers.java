package src.AddTwoNumbers;

/**
 * Created by tongqi on 2017/4/11.
 * Email: tongqicode@126.com
 */

//解题思路：模拟即可

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode head = pre;

        int overplus = 0;
        while(l1 != null || l2 != null || overplus != 0)
        {
            ListNode cur = new ListNode(0);
            cur.val = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + overplus;

            overplus = cur.val / 10;
            cur.val %= 10;
            pre.next = cur;
            pre = pre.next;

            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        return head.next;
    }
}
