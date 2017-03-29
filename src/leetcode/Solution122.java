package leetcode;

/**
 * Created by nick on 2017/3/17.
 */
/**
 * 讲道理，这两道股票的题做起来还是挺有趣的。
 * 虽然都是easy的题，但是第一次做思路都不直观，还好抱着O(n)的想法都完成。
 * 第二个题实际上是想通一个不等式就行，就是说假如有1，3,2,5这四个点，那么（3 -1）+ （5 - 2）一定大于（5 - 1），因此在一次遍历中
 * 只关注相邻两个节点的大小特性及前一个节点的买还是卖的性质即可决定在这个点相应的买卖操作。
 *
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int sumProfit = 0;
        int tmpProfit = 0;
        boolean prePointS = true; // true -- buy point; false -- sell point;
        for (int i = 1; i < prices.length; i++) {
            if (prePointS) {
                if (prices[i] > prices[i - 1]) {
                    prePointS = false;
                    tmpProfit = prices[i] - prices[i - 1];
                }
            } else {
                if (prices[i] >= prices[i - 1]) {
                    tmpProfit += prices[i] - prices[i - 1];
                } else {
                    sumProfit += tmpProfit;
                    tmpProfit = 0;
                    prePointS = true;
                }
            }
        }
        if (!prePointS) {
            sumProfit += tmpProfit;
        }
        return sumProfit;
    }
}
