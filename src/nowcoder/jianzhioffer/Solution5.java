package nowcoder.jianzhioffer;

import java.util.Stack;

/**
 * Created by nick on 2017/4/25.
 */
public class Solution5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    int mode = 1; //1, push; 2, pop
    Stack<Integer> workStack = stack1;
    Stack<Integer> emptyStack = stack2;

    public void push(int node) {
        if (mode == 1) {
            workStack.push(node);
        } else {
            while (!workStack.isEmpty()) {
                emptyStack.push(workStack.pop());
            }
            Stack<Integer> tmp = workStack;
            workStack = emptyStack;
            emptyStack = tmp;
            mode = 1;
            workStack.push(node);
        }
    }

    public int pop() {
        if (mode == 2) {
            return workStack.pop();
        } else {
            while (!workStack.isEmpty()) {
                emptyStack.push(workStack.pop());
            }
            Stack<Integer> tmp = workStack;
            workStack = emptyStack;
            emptyStack = tmp;
            mode = 2;
            return workStack.pop();
        }
    }
}
