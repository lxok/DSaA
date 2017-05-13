package nowcoder.jianzhioffer;

import java.util.ArrayList;

/**
 * Created by nick on 2017/5/3.
 *
 * 连续正数序列和
 */
public class Solution41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum < 3) {
            return res;
        }
        int small = 1;
        int big = 2;
        int r = (sum + 1) / 2;
        int s = 3;
        while (small < r && big < sum) {
            if (s < sum) {
                big++;
                s += big;
            } else if (s > sum) {
                s -= small;
                small++;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                res.add(list);
                s -= small;
                small++;
                big++;
                s += big;
            }
        }
        return res;
    }
}
