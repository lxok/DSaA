package leetcode;

/**
 * Created by nick on 2016/12/28.
 */
/**
 * 每一次l和r移动互换的时候，实际上sh都要重新被刷新一遍。
 * 因为已经移动过的L和r总比接下来l和r互换时的高度矮，因此对于另一侧来说，sh其实就需要重新被刷新。
 */
public class Solution42 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int sh = 0;
        int area = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                sh = Math.max(sh, height[l]);
                area += sh - height[l];
                l++;
            } else {
                sh = Math.max(sh, height[r]);
                area += sh - height[r];
                r--;
            }
        }
        return area;
    }
}
