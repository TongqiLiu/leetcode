package src.ImplementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mingqiao
 * @Date 2020/3/5
 */
public class MyStack {

    /**
     * 定义input为输入队列，output为输出队列，input始终保持Push后为空
     */
    Queue<Integer> input;
    Queue<Integer> output;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        input = new LinkedList<>();
        output = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        input.offer(x);

        while (!output.isEmpty()) {
            input.offer(output.poll());
        }

        Queue<Integer> tmp = input;
        input = output;
        output = tmp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return output.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return output.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return output.isEmpty();
    }
}
