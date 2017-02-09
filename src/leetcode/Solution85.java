package leetcode;

import java.util.Stack;

/**
 * Created by nick on 2017/1/15.
 */
public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] row = new int[matrix[0].length + 1];
        row[row.length - 1] = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    row[j] = 0;
                } else {
                    row[j] += 1;
                }
            }
            maxArea = Math.max(maxArea, largestRectangle(row));
        }
        return maxArea;
    }

    public int largestRectangle(int[] row) {
        int maxArea = 0;
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < row.length) {
            while (!stack.empty() && row[stack.peek()] > row[i]) {
                int index = stack.pop();
                if (stack.empty()) {
                    maxArea = Math.max(maxArea, row[index] * i);
                } else {
                    maxArea = Math.max(maxArea, row[index] * (i - stack.peek() - 1));
                }
            }
            stack.push(i++);
        }
        return maxArea;
    }
}
