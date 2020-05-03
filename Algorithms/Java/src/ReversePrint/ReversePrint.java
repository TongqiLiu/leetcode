package src.ReversePrint;

import java.util.Stack;

import src.A_Common_Package.ListNode;

/**
 * @author mingqiao
 * @Date 2020/3/25
 */
public class ReversePrint {

    /**
     * 用栈完成反序
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int cnt = 0;
        while (!stack.isEmpty()) {
            res[cnt++] = stack.pop();
        }
        return res;
    }
}
