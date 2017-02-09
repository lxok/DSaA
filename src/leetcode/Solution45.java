package leetcode;

/**
 * Created by nick on 2016/12/31.
 */
public class Solution45 {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int curIndex = 0;
        int value;
        int tmpValue = 0;
        int tmpIndex = 0;
        while (curIndex < nums.length - 1) {
            value = nums[curIndex];
            if (curIndex + value >= nums.length - 1) {
                res++;
                break;
            }
            for (int i = 0; i <= value; i++) {
                if (nums[curIndex + i] + i > tmpValue) {
                    tmpValue = nums[curIndex + i] + i;
                    tmpIndex = curIndex + i;
                }
            }
            curIndex = tmpIndex;
            res++;
            tmpValue = 0;
            tmpIndex = 0;
        }
        return res;
    }
}
