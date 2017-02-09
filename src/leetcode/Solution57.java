package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2017/1/3.
 */
public class Solution57 {
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null) {
            return res;
        }
        if (newInterval == null) {
            return intervals;
        }
        if (intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        int i;
        for (i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).start < newInterval.start && intervals.get(i).end < newInterval.start) {
                res.add(intervals.get(i));
            } else {
                break;
            }
        }
        if (i == intervals.size()) {
            res.add(newInterval);
            return res;
        }
        int start;
        int end;
        if (newInterval.start <= intervals.get(i).start) {
            start = newInterval.start;
            end = newInterval.end;
        } else {
            start = intervals.get(i).start;
            end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }
        for (; i < intervals.size(); i++) {
            if (intervals.get(i).start <= end) {
                end = Math.max(intervals.get(i).end, end);
            }  else {
                break;
            }
        }
        res.add(new Interval(start, end));
        for (; i < intervals.size(); i++) {
            res.add(intervals.get(i));
        }
        return res;
    }
}
