package leetcode;

/**
 * Created by nick on 2017/3/17.
 */
/**
 * 做这个题的时候糊住了，
 * 两个O(n)串行还是O(n),不是O(n^2)啊兄弟
 * 所以明知道是分割，就是不知道咋把两次O(n)放在一个循环里写
 * 你可以串行写啊兄弟啊
 */
public class Solution123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int min = prices[0];
        int[] record1 = new int[prices.length];
        record1[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - min;
            if (tmp > maxProfit) {
                maxProfit = tmp;
            } else if (prices[i] < min) {
                min = prices[i];
            }
            record1[i] = maxProfit;
        }

        int[] record2 = new int[prices.length];
        record2[prices.length - 1] = 0;
        maxProfit = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >=0; i--) {
            int tmp = max - prices[i];
            if (tmp > maxProfit) {
                maxProfit = tmp;
            } else if (prices[i] > max) {
                max = prices[i];
            }
            record2[i] = maxProfit;
        }

        maxProfit = 0;
        for (int i = 1; i < prices.length - 2; i++) {
            int tmp = record1[i] + record2[i + 1];
            if (tmp > maxProfit) {
                maxProfit = tmp;
            }
        }
        maxProfit = (record1[prices.length - 1] > maxProfit) ? record1[prices.length - 1] : maxProfit;
        return maxProfit;
    }
}
