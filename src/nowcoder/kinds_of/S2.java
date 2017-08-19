package nowcoder.kinds_of;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by nick on 2017/7/12.
 */
public class S2 {
    public static int resolve(ArrayList<Integer> ids, ArrayList<Integer> parents, ArrayList<Integer> costs) {
        if (ids == null || ids.size() == 0) {
            return 0;
        }
        for (int i = 1; i < ids.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (parents.get(j - 1) > parents.get(j)) {
                    swap(ids, j - 1, j);
                    swap(parents, j - 1, j);
                    swap(costs, j - 1, j);
                } else {
                    break;
                }
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ids.size(); i++) {
            int f = parents.get(i);
            if (f == 0) {
                map.put(ids.get(i), costs.get(i));
            } else {
                if (map.containsKey(f)) {
                    map.put(ids.get(i), map.get(f) + costs.get(i));
                } else {
                    map.put(ids.get(i), map.put(ids.get(i), costs.get(i)));
                }
            }
            max = Math.max(max, map.get(ids.get(i)));
        }
        return max;
    }

    static void swap(ArrayList<Integer> ids, int i, int j) {
        int tmp1 = ids.get(i);
        int tmp2 = ids.get(j);
        ids.set(i, tmp2);
        ids.set(j, tmp1);
    }


    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(5);
        a.add(2);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(0);
        b.add(1);
        b.add(1);
        b.add(0);
        ArrayList<Integer> c = new ArrayList<>();
        c.add(2);
        c.add(2);
        c.add(3);
        c.add(3);
        int res = S2.resolve(a, b, c);
        System.out.println(res);
    }
}
