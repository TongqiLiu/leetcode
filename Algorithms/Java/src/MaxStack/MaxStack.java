package src.MaxStack;

import java.util.Stack;

/**
 * @author mingqiao
 * @Date 2020/2/12
 */
public class MaxStack {

    /**
     * 以空间换时间，增加一个最大栈
     */
    private Stack<Integer> data;
    private Stack<Integer> maxData;

    /**
     * initialize your data structure here.
     */
    public MaxStack() {
        data = new Stack<>();
        maxData = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (maxData.isEmpty() || maxData.peek() <= x) {
            maxData.add(x);
        } else {
            maxData.add(maxData.peek());
        }
    }

    public int pop() {
        if (!maxData.isEmpty() && !data.isEmpty()) {
            maxData.pop();
            return data.pop();
        }
        return -1;
    }

    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        return -1;
    }

    public int peekMax() {
        if (!maxData.isEmpty()) {
            return maxData.peek();
        }
        return -1;
    }

    /**
     * 这里繁琐些，需要定位到max在的位置然后删除重新入栈，复杂度O(N)
     *
     * @return
     */
    public int popMax() {
        int max = peekMax();
        Stack<Integer> tmp = new Stack<>();
        while (top() != max) {
            tmp.push(pop());
        }
        pop();
        while (!tmp.isEmpty()) {
            push(tmp.pop());
        }
        return max;
    }
}
