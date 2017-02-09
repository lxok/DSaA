package leetcode;

import java.util.Arrays;

/**
 * Created by nick on 2016/11/23.
 */
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        if (nums.length < 3) {
            return res;
        }
        int l;
        int r;
        int s;
        for (int i = 0; i < nums.length - 2; i++) {
            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                s = nums[i] + nums[l] + nums[r];
                if (s == target) {
                    res = target;
                    break;
                }
                if (abs(target, s) < abs(target, res)) {
                    res = s;
                }
                if (s < target) {
                    l++;
                } else {
                    r--;
                }
            }
            if (res == target) {
                break;
            }
        }
        return res;
    }

    public int abs(int a, int b) {
        if (a == Integer.MAX_VALUE && b < 0)    {
            return Integer.MAX_VALUE;
        }
        if (b == Integer.MAX_VALUE && a < 0) {
            return Integer.MAX_VALUE;
        }
        return (a < b)? (b - a): (a - b);
    }

    public static void main(String[] args) {
        Solution16 s = new Solution16();
        int[] a = {1,1,1,1};
        int t = -100;
        int r = s.threeSumClosest(a, t);
        System.out.println(r);
    }
}
