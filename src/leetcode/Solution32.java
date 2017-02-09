package leetcode;

import java.util.Stack;

/**
 * Created by nick on 2016/12/21.
 */
public class Solution32 {
    public int longestValidParentheses(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        char[] sa = s.toCharArray();
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int index;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (sa[i] == '(') {
                stack.push(i);
                if (start == -1) {
                    start = i;
                }
            } else {
                if (!stack.empty()) {
                    stack.pop();
                    if (stack.empty()) {
                        res = Math.max(res, i - start + 1);
                    } else {
                        res = Math.max(res, i -stack.peek());
                    }
                } else {
                    start = -1;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution32 s = new Solution32();
        System.out.println(s.longestValidParentheses("(()()"));
    }
}
