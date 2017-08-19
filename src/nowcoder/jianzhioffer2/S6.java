package nowcoder.jianzhioffer2;
import java.util.Stack;

/**
 * Created by nick on 2017/7/4.
 */
public class S6 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    boolean f = true;

    public void push(int node) {
        if (!f) {
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
            f = true;
        }
        stack1.push(node);
    }

    public int pop() {
        if (f) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            f = false;
        }
        return stack2.pop();
    }
}
