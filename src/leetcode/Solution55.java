package leetcode;

/**
 * Created by nick on 2017/1/2.
 */
public class Solution55 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)  {
            return false;
        }
        int index = 0;
        int max;
        int next;
        int length;
        while(index + nums[index] < nums.length - 1) {
            if (nums[index] == 0) {
                return false;
            }
            max = 0;
            next = 0;
            for (int i = 1; i <= nums[index]; i++) {
                length = i + nums[index + i];
                if (length >= max) {
                    next = index + i;
                    max = length;
                }
            }
            index = next;
        }
        return true;
    }
}
