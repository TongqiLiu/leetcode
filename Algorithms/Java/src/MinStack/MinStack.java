package src.MinStack;

import java.util.Stack;

/**
 * @author mingqiao
 * @Date 2020/2/10
 */
public class MinStack {

    /**
     * 以空间换时间，增加一个最小栈
     */
    private Stack<Integer> data;
    private Stack<Integer> minData;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new Stack<>();
        minData = new Stack<>();
    }

    public void push(int x) {
        data.add(x);
        // 如果x比栈顶元素peek大，则证明x出栈后最小值还是peek，故mock一个peek加进去用来保持出栈同步
        if (minData.isEmpty() || x <= minData.peek()) {
            minData.add(x);
        } else {
            minData.add(minData.peek());
        }
    }

    public void pop() {
        if (!data.isEmpty()) {
            minData.pop();
            data.pop();
        }
    }

    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        return -1;
    }

    public int getMin() {
        if (!minData.isEmpty()) {
            return minData.peek();
        }
        return -1;
    }
}
