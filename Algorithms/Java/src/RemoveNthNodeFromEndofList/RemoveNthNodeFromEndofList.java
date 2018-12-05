package src.RemoveNthNodeFromEndofList;

import java.util.ArrayList;
import java.util.List;

/**
 * author: mingqiao
 * Date: 2018/11/29
 */
//题解：1.搞一个list，直接把第(length - n + 1)个结点"移除"掉，注意前面补个空结点这样如果是首节点移除就不需要特判了
//2.看了题解后的思路，快慢指针的玩法，保持快指针领先慢指针n个结点，这样当快指针到终点时，慢指针刚好到被删除结点
public class RemoveNthNodeFromEndofList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> linkList = new ArrayList<>();
        ListNode firstNode = new ListNode(0);
        firstNode.next = head;
        while (firstNode != null) {
            linkList.add(firstNode);
            firstNode = firstNode.next;
        }

        int index = linkList.size() - n ;
        linkList.get(index - 1).next = linkList.get(index).next;
        return linkList.get(0).next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode firstNode = new ListNode(0);
        firstNode.next = head;
        ListNode fastNode = firstNode, slowNode = firstNode;
        for(int i = 0; i < n + 1; i++) {
            fastNode = fastNode.next;
        }
        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return firstNode.next;
    }
}
