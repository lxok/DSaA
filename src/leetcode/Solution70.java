package leetcode;

/**
 * Created by nick on 2017/1/7.
 */
/**
 * 动态规划！so easy! so典型!
 */
public class Solution70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] pn = new int[n];
        pn[0] = 1;
        pn[1] = 2;
        for (int i = 2; i < pn.length; i++) {
            pn[i] = pn[i - 1] + pn[i - 2];
        }
        return pn[n - 1];
    }
}
