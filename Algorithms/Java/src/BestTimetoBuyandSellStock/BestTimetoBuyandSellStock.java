package src.BestTimetoBuyandSellStock;

import java.util.Stack;

/**
 * @author mingqiao
 * @Date 2020/2/1
 */
public class BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int ans = 0, min = prices[0];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            if (stack.isEmpty() || prices[i] > stack.peek()) {
                ans = Math.max(ans, prices[i] - min);
                stack.push(prices[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() >= prices[i]) {
                    stack.pop();
                }
                min = Math.min(min, prices[i]);
                stack.push(prices[i]);
            }
        }
        return ans;
    }
}
