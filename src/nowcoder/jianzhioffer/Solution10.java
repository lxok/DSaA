package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/4/26.
 */
public class Solution10 {
    public int RectCover(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 0;
        if (dp.length >= 2) {
            dp[1] = 1;
        }
        if (dp.length >= 3) {
            dp[2] = 2;
        }
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }
}
