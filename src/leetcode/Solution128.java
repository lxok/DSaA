package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nick on 2017/3/20.
 */
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        Map<Integer, Integer> up = new HashMap<>(len);
        Map<Integer, Integer> down = new HashMap<>(len);
        int max = 1;
        int val;
        for (int i = 0; i < len; i++) {
            val = nums[i];
            if (up.containsKey(val)) {
                continue;
            }
            int pri = val - 1;
            int next = val + 1;
            int range = 1;
            up.put(val, val);
            down.put(val, val);
            int nextRange;
            int priRange;
            if (up.containsKey(next)) {
                nextRange = up.get(next);
                up.put(val, nextRange);
                range += nextRange - val;
            }
            if (down.containsKey(pri)) {
                priRange = down.get(pri);
                down.put(val, priRange);
                range += val - priRange;
            }
            if (range > max) {
                max = range;
            }

            //modify
            if (up.containsKey(next)) {
                nextRange = up.get(val);
                down.put(nextRange, Math.min(down.get(val), down.get(nextRange)));
                down.put(next, Math.min(down.get(val), down.get(next)));
            }
            if (down.containsKey(pri)) {
                priRange = down.get(val);
                up.put(priRange, Math.max(up.get(val), up.get(priRange)));
                up.put(pri, Math.max(up.get(val), up.get(pri)));
            }
        }
        return max;
    }
}
