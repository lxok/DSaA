package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/4/26.
 */
public class Solution7 {
    public int Fibonacci(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        if (dp.length >= 2) {
            dp[1] = 1;
        }
        if (dp.length >= 3) {
            dp[2] = 1;
        }
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
