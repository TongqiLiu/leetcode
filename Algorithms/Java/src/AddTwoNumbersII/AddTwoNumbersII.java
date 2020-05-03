package src.AddTwoNumbersII;

import java.util.Stack;

import src.A_Common_Package.ListNode;

/**
 * @author mingqiao
 * @Date 2020/4/20
 */
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = null;

        int overplus = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || overplus != 0) {
            ListNode cur = new ListNode(0);
            cur.val = (!stack1.isEmpty() ? stack1.pop() : 0) + (!stack2.isEmpty() ? stack2.pop() : 0) + overplus;
            overplus = cur.val / 10;
            cur.val %= 10;

            cur.next = head;
            head = cur;
        }
        return head;
    }
}