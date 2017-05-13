package nowcoder.jianzhioffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by nick on 2017/5/9.
 *
 * 数组滑动窗口求最大值--保持一个动态排序的结构，所以关键点是双端队列。
 */
public class Solution64 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length == 0) {
            return res;
        }
        if (size < 1 || size > num.length) {
            return res;
        }
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < size - 1; i++) {
            while (!q.isEmpty() && num[i] > num[q.getLast()]) {
                q.removeLast();
            }
            q.addLast(i);
        }

        for (int i = size - 1; i < num.length; i++) {
            while (!q.isEmpty() && num[i] > num[q.getLast()]) {
                q.removeLast();
            }
            if (!q.isEmpty() && i - q.getFirst() >= size) {
                q.removeFirst();
            }
            q.addLast(i);
            res.add(num[q.getFirst()]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution64 s = new Solution64();
        s.maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3);
    }
}

