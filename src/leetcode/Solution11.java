package leetcode;

/**
 * Created by nick on 2016/11/22.
 *
 * 1. force.  Time Limit Exceeded
 * 2. 暴力，减枝，比最高值起点高度低的后面起点不需要遍历。Time Limit Exceeded
 * 3. 左右端向中间转移。每次矮的向中间转移。动态规划。
 *
 *
 */


public class Solution11 {
    public int maxArea3(int[] height) {
        int max = 0;
        int s;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            s = (right - left) * ((height[left] > height[right])?height[right]: height[left]);
            if (s > max) {
                max = s;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int max = 0;
        int s;
        int maxStartHeight = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] <= maxStartHeight) {
                continue;
            }
            for (int j = i + 1; j < height.length; j++) {
                s = (j - i) * ((height[i] > height[j])?height[j]: height[i]);
                if (s > max) {
                    max = s;
                    maxStartHeight = height[i];
                }
            }
        }
        return max;
    }

    //force
    public int maxArea1(int[] height) {
        int max = 0;
        int s;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                s = (j - i) * ((height[i] > height[j])?height[j]: height[i]);
                if (s > max) {
                    max = s;
                }
            }
        }
        return max;
    }
}
