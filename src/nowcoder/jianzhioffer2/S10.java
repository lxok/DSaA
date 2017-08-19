package nowcoder.jianzhioffer2;

/**
 * Created by nick on 2017/7/5.
 */
public class S10 {
    public int JumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        int pri = 2;
        for (int i = 2; i <= target; i++) {
            dp[i] = pri;
            pri += dp[i];
        }
        return dp[target];
    }
}
