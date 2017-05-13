package nowcoder.jianzhioffer;

import java.util.ArrayList;

/**
 * Created by nick on 2017/5/4.
 */
public class Solution42 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length == 0) {
            return res;
        }
        int small = 0;
        int big = array.length - 1;
        int s;
        while (small < big) {
            s = array[small] + array[big];
            if (s < sum) {
                small++;
            } else if (s > sum) {
                big--;
            } else {
                res.add(array[small]);
                res.add(array[big]);
                return res;
            }
        }
        return res;
    }
}
