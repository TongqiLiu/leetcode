package src.DeleteNodeInALinkedList;

import src.A_Common_Package.ListNode;

/**
 * @author mingqiao
 * @Date 2020/3/12
 */
public class DeleteNodeInALinkedList {

    /**
     * 直接删除
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
