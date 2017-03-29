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
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int p = val - 1;
            int n = val + 1;
            if (map.containsKey(p) && map.get(p) <= p) {
                
            }
        }
        return -1;
    }
}
