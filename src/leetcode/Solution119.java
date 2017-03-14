package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2017/3/14.
 */
public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i < rowIndex + 1; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i) {
                    list.add(j,1);
                } else if (j == 0) {
                    list.set(0, 1);
                } else {
                    list.set(j, list.get(j) + list.get(j - 1));
                }
            }
        }
        return list;
    }
}

