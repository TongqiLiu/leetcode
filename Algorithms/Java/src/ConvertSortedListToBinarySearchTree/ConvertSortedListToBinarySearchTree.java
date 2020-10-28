package src.ConvertSortedListToBinarySearchTree;

import src.A_Common_Package.ListNode;
import src.A_Common_Package.TreeNode;

/**
 * @author mingqiao
 * @Date 2020/10/27
 */
public class ConvertSortedListToBinarySearchTree {

    /**
     * 先找到中间节点及其前驱节点，然后又演变成了寻找左右两链表相同排序的子问题递归求解
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
