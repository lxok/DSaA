package nowcoder.jianzhioffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by nick on 2017/5/9.
 */
public class Solution63 {
    PriorityQueue<Integer> p = new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    PriorityQueue<Integer> q = new PriorityQueue<>();

    public void Insert(Integer num) {
        if (p.isEmpty() || num <= p.peek()) {
            p.offer(num);
        } else {
            q.offer(num);
        }
        if (p.size() == q.size() + 2) {
            q.offer(p.poll());
        } else if (p.size() + 1 == q.size()) {
            p.offer(q.poll());
        }
    }

    public Double GetMedian() {
        return (p.size() == q.size()) ? (double)(p.peek()+ q.peek()) / 2 : (double)p.peek();
    }

    public static void main(String[] args) {
        Solution63 s = new Solution63();
        s.Insert(5);
        System.out.println(s.GetMedian());
        s.Insert(2);
        System.out.println(s.GetMedian());
        s.Insert(3);
        System.out.println(s.GetMedian());
    }
}
