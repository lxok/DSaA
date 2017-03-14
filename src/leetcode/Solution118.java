package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2017/3/14.
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res= new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i + 1);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
                }
            }
            res.add(list);
        }
        return res;
    }
}
