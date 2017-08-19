package nowcoder.mianshijindian;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by nick on 2017/6/11.
 */
public class S16 {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        ArrayList<Integer> res = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return res;
        }
        int len = numbers.length;
        if (len == 1) {
            res.add(numbers[0]);
            return res;
        }
        if (len == 2) {
            int max = Math.max(numbers[0], numbers[1]);
            int min = Math.min(numbers[0], numbers[1]);
            res.add(max);
            res.add(min);
            return res;
        }
        LinkedList<Integer> l1 = new LinkedList();
        for (int i = len - 1; i >= 0 ; i--) {
            l1.push(numbers[i]);
        }
        LinkedList<Integer> l2 = new LinkedList<>();
        int count = len;
        int val;
        int tmp;
        for (int i = 0; i < len - 1; i++) {
            val = l1.pop();
            for (int j = 1; j < count; j++) {
                tmp = l1.pop();
                if (tmp < val) {
                    l2.push(val);
                    val = tmp;
                } else {
                    l2.push(tmp);
                }
            }
            l1.push(val);
            count--;
            for (int j = 0; j < count; j++) {
                l1.push(l2.pop());
            }
        }
        for (int i = 0; i < len; i++) {
            res.add(l1.pop());
        }
        return res;
    }
}
