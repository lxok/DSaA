package leetcode;

/**
 * Created by nick on 2017/3/15.
 */
public class Solution121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - min;
            if (tmp > profit) {
                profit = tmp;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return profit;
    }
}
