package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/4/26.
 */
public class Solution9 {
    public int JumpFloorII(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        if (dp.length >= 2) {
            dp[1] = 1;
        }
        int sum = 2;
        for (int i = 2; i < dp.length; i++) {
               dp[i] = sum;
               sum += dp[i];
        }
        return dp[target];
    }
}
