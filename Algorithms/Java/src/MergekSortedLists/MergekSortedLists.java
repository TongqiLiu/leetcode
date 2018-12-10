package src.MergekSortedLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * author: mingqiao
 * Date: 2018/12/6
 */
//题解：解法一：直接数据一起重组为新的数组，排序跑一下，时间复杂度O(N * logN)，其中N = SUM[节点个数]
//解法二：可以用归并排序分治处理下，两两重组，时间复杂度O(N * logN)
//解法三：看了下题解，最小堆的解法，构造一个长度为k的优先队列，将k个表头先放进去，然后弹出队列头，将该节点next节点加进去，复杂度O(N * logk)
public class MergekSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode listNode = lists[i];

            while (listNode != null) {
                numList.add(listNode.val);
                listNode = listNode.next;
            }
        }
        Collections.sort(numList);

        ListNode firstNode = new ListNode(-1);
        ListNode resultNode = firstNode;

        for (Integer number : numList) {
            resultNode.next = new ListNode(number);
            resultNode = resultNode.next;
        }
        return firstNode.next;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
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

    public ListNode dfs(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        int mid = (left + right) / 2;
        return merge(dfs(lists, left, mid), dfs(lists, mid + 1, right));
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return dfs(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode firstNode = new ListNode(-1);
        ListNode resultNode = firstNode;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.add(listNode);
            }
        }

        while (!queue.isEmpty()) {
            ListNode peek = queue.poll();
            resultNode.next = peek;
            resultNode = resultNode.next;
            if(peek.next != null) {
                queue.add(peek.next);
            }
        }
        return firstNode.next;
    }
}
