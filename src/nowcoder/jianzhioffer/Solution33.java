package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/1.
 */
public class Solution33 {
    public int GetUglyNumber_Solution(int index) {
        if (index < 1) {
            return 0;
        }
        int[] nums = new int[index];
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        nums[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.min(Math.min(nums[t3] * 3, nums[t5] * 5), nums[t2] * 2);
            if (nums[i] == nums[t2] * 2) t2++;
            if (nums[i] == nums[t3] * 3) t3++;
            if (nums[i] == nums[t5] * 5) t5++;
        }
        return nums[index - 1];
    }
}
