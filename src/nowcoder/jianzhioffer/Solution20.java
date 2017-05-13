package nowcoder.jianzhioffer;

import java.util.Stack;
/**
 * Created by nick on 2017/4/27.
 */
public class Solution20 {
    Stack<Integer> stack = new Stack<>();

    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        Stack<Integer> tmp = new Stack<>();
        int min = Integer.MAX_VALUE;
        int val;
        while (!stack.empty()) {
            val = stack.pop();
            min = Math.min(min, val);
            tmp.push(val);
        }
        while (!tmp.empty()) {
            stack.push(tmp.pop());
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        } else {
            return min;
        }
    }
}
