package src.AllO1DataStructure;

import java.util.HashMap;
import java.util.Map;

public class AllO1DataStructure {

    private Node head;
    private Node tail;
    private Map<String, Node> map;

    /**
     * 利用hashmap和同时维护双向链表实现查找和获取最大值、最小值的key
     * Initialize your data structure here.
     */
    public AllO1DataStructure() {
        head = new Node("head", -1);
        tail = new Node("tail", -1);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        map.merge(key, new Node(key, 1), (v1, v2) -> {
            v1.value++;
            return v1;
        });
        map.get(key).moveToTail(head, tail);
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        Node temp = map.get(key);
        map.computeIfPresent(key, (k, v) -> {
            v.value--;
            if (v.value == 0) {
                return null;
            }
            return v;
        });
        if (map.containsKey(key)) {
            map.get(key).moveToHead(head);
        } else {
            if (temp != null) {
                temp.delete();
            }
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        if (map.isEmpty()) {
            return "";
        } else {
            return tail.pre.key;
        }
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        if (map.isEmpty()) {
            return "";
        } else {
            return head.next.key;
        }
    }
}

class Node {

    String key;
    int value;
    Node pre;
    Node next;

    Node(String key, int value) {
        this.key = key;
        this.value = value;
        pre = null;
        next = null;
    }

    void moveToTail(Node head, Node tail) {
        if (pre == next && pre == null) {
            next = head.next;
            pre = head;
            next.pre = this;
            head.next = this;
        } else if (next != tail) {
            while (this.value > next.value && next != tail) {
                pre.next = next;
                next.pre = pre;

                Node temp = next;
                next = temp.next;
                temp.next = this;

                pre = temp;
                next.pre = this;
            }
        }
    }

    void moveToHead(Node head) {
        if (pre != head) {
            if (this.value < pre.value) {
                pre.next = next;
                next.pre = pre;

                Node temp = pre;
                next = temp;
                pre = temp.pre;

                pre.next = this;
                temp.pre = this;
            }
        }
    }

    void delete() {
        pre.next = next;
        next.pre = pre;
        pre = null;
        next = null;
    }
}