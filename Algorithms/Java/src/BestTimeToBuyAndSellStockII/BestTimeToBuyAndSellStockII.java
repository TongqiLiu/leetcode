package src.BestTimeToBuyAndSellStockII;

/**
 * @author mingqiao
 * @Date 2020/2/5
 */
public class BestTimeToBuyAndSellStockII {

    /**
     * 这里存在一个贪心原则是只要每天有赚那就一直累加，比如A，B，C三个自然日都是自然上升趋势
     * 那么(price[c] - price[a]) = (price[b] - price[a]) + (price[c] - price[b])
     * 故只要有升的趋势即可买入
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[] diff = new int[prices.length - 1];
        for (int i = 0; i < prices.length - 1; i++) {
            diff[i] = prices[i + 1] - prices[i];
        }

        int ans = 0;
        for (int i = 0; i < diff.length; i++) {
            if(diff[i] > 0) {
                ans += diff[i];
            }
        }
        return ans < 0 ? 0 : ans;
    }
}
