package nowcoder.mianshijindian;

import java.util.LinkedList;

/**
 * Created by nick on 2017/6/26.
 */
public class NextElement {
    public int[] findNext(int[] A, int n) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                if (stack.peek() > A[i]) {
                    res[i] = stack.peek();
                    stack.push(A[i]);
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                res[i] = -1;
                stack.push(A[i]);
            }
        }
        return res;
    }
}
