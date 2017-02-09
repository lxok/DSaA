package leetcode;

import java.util.HashMap;

/**
 * Created by nick on 2016/11/2.
 */
public class Q_1 {
    public class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> hash = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                hash.put(nums[i], i);
            }
            int ii;
            for (int i = 0; i < nums.length; i++) {
                ii = target - nums[i];
                Integer val = hash.get(ii);
                if (val != null && val != i) {
                    int[] res = {i, val};
                    return res;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Q_1 q = new Q_1();
        Solution s = q.new Solution();
        int[] nums = {3, 2, 4};
        int[] res = s.twoSum(nums, 6);
        for (int i : res) {
            System.out.println(i);
        }
    }
}


