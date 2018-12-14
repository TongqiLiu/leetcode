package src.SwapNodesInPairs;

/**
 * author: mingqiao
 * Date: 2018/12/14
 */
//题解：两两互换，直至待交换节点<2，递归写起来比循环舒服
public class SwapNodesInPairs {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode virtualNode = new ListNode(-1);
        virtualNode.next = head;

        ListNode iterNode = virtualNode, firstNode = iterNode.next, secondNode = firstNode.next;
        while (firstNode != null && secondNode != null) {
            ListNode thirdNode = secondNode.next;
            iterNode.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = thirdNode;

            if (thirdNode != null) {
                iterNode = firstNode;
                firstNode = iterNode.next;
                secondNode = firstNode.next;
            } else {
                break;
            }
        }
        return virtualNode.next;
    }

    public ListNode swapPairs1(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode nextNode = head.next;
        nextNode.next = head;
        head.next = swapPairs(head.next.next);
        return nextNode;
    }
}
