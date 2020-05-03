package src.MaxQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mingqiao
 * @Date 2020/3/8
 */
public class MaxQueue {

    private Deque<Integer> deque;
    private Deque<Integer> increase;

    /**
     * 题目地址：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
     * 维护一个真实队列及一个单调递增的队列
     */
    public MaxQueue() {
        deque = new LinkedList<>();
        increase = new LinkedList<>();
    }

    public int max_value() {
        return !increase.isEmpty() ? increase.peek() : -1;
    }

    public void push_back(int value) {
        deque.offer(value);
        while (!increase.isEmpty() && increase.peekLast() < value) {
            increase.pollLast();
        }
        increase.offer(value);
    }

    public int pop_front() {
        if (deque.isEmpty()) {
            return -1;
        }
        int value = deque.pop();
        if (increase.peek() == value) {
            increase.remove(value);
        }
        return value;
    }
}
