package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by nick on 2017/1/2.
 */
public class Solution56 {
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    class MyComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        Collections.sort(intervals, new MyComparator());
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 0; i < intervals.size(); i++) {
            Interval inter = intervals.get(i);
            if (inter.start <= end) {
                end = Math.max(end, inter.end);
            } else {
                res.add(new Interval(start, end));
                start = inter.start;
                end = inter.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}









