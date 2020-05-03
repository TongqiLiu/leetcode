package src.ImplementQueueUsingStacks;

import java.util.Stack;

/**
 * @author mingqiao
 * @Date 2020/3/9
 */
public class MyQueue {

    Stack<Integer> input;
    Stack<Integer> output;

    /**
     * Initialize your data structure here.
     * 定义两个栈，和MyStack方法类似
     */
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!output.isEmpty()) {
            input.add(output.pop());
        }
        input.add(x);

        while (!input.isEmpty()) {
            output.add(input.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return output.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return output.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return output.isEmpty();
    }
}
