package leetcode;

/**
 * Created by nick on 2017/1/2.
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
