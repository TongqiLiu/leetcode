package src.CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

import src.A_Common_Package.Node;

/**
 * @author mingqiao
 * @Date 2020/3/18
 */
public class CopyListWithRandomPointer {

    /**
     * hashMap遍历并存储下关系
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node node = head;
        Map<Node, Node> map = new HashMap<>();
        while (node != null) {
            Node tmp = new Node(node.val);
            map.put(node, tmp);
            node = node.next;
        }
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}
