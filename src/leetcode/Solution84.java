package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by nick on 2017/1/14.
 */
/**
 * 关键是确定已当前值为最低高度的起始点的问题，当数组中出现0值时，算法依然能保证起始点问题。
 */
public class Solution84 {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int[] h = Arrays.copyOf(height, height.length + 1);
        for (int i = 0; i < h.length; i++) {
            while (!stack.empty() && h[stack.peek()] > h[i]) {
                int index = stack.pop();
                if (stack.empty()) {
                    maxArea = Math.max(maxArea, h[index] * i);
                } else {
                    maxArea = Math.max(maxArea, h[index] * (i - stack.peek() - 1));
                }
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution84 s = new Solution84();
        s.largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
}
