package LintCode;

import java.util.ArrayList;

/**
 * Created by nick on 2017/8/15.
 */
public class S6 {
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            min = Math.min(min, sum);
            if (sum > 0) {
                sum = 0;
            }
        }
        return min;
    }
}
