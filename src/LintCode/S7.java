package LintCode;

import java.util.*;

/**
 * Created by nick on 2017/8/17.
 */
public class S7 {
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        int len = nums.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        int val;
        int size;
        for (int i = 0; i < len; i++) {
            val = nums.get(i);
            size = map.size();
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                if (size == k - 1) {
                    Set<Map.Entry<Integer, Integer>> s = map.entrySet();
                    Iterator<Map.Entry<Integer, Integer>> ite = s.iterator();
                    while (ite.hasNext()) {
                        Map.Entry<Integer, Integer> e = ite.next();
                        int v = e.getValue();
                        if (v > 1) {
                            map.put(e.getKey(), v - 1);
                        } else {
                            ite.remove();
                        }
                    }
                } else {
                    map.put(val, 1);
                }
            }
        }
        Set<Map.Entry<Integer, Integer>> s = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> ite = s.iterator();
        while (ite.hasNext()) {
            Map.Entry<Integer, Integer> e = ite.next();
            map.put(e.getKey(), 0);
        }
        int resk = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            val = nums.get(i);
            if (map.containsKey(val)) {
                int count = map.get(val) + 1;
                map.put(val, count);
                if (count > max) {
                    resk = val;
                    max = count;
                }
            }
        }
        return resk;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        int i = 1;
        Set<Map.Entry<Integer, Integer>> s = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> ite = s.iterator();
        while (ite.hasNext()) {
            ite.next();
            map.put(i++, 2);
        }
    }
}
