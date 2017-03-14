package leetcode;

import java.util.List;

/**
 * Created by nick on 2017/3/14.
 */
public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] record = new int[row];
        List<Integer> down = triangle.get(row - 1);
        for (int j = 0; j <= row - 1; j++) {
            record[j] = down.get(j);
        }
        for (int i = row - 2; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                record[j] = list.get(j) + Math.min(record[j], record[j + 1]);
            }
        }
        return record[0];
    }
}
