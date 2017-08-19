package LintCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2017/8/18.
 */
public class S8 {
    public List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
        int len = nums.size();
        long[] lm = new long[len];
        long[] rm = new long[len];
        long tmp = 1;
        for (int i = 0; i < len - 1; i++) {
            tmp *= nums.get(i);
            lm[i] = tmp;
        }
        tmp = 1;
        for (int i = len - 1; i > 0; i--) {
            tmp *= nums.get(i);
            rm[i] = tmp;
        }
        List<Long> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i - 1 >= 0 && i + 1 < len) {
                res.add(lm[i - 1] * rm[i + 1]);
            } else if (i - 1 >= 0) {
                res.add(lm[i - 1]);
            } else {
                res.add(rm[i + 1]);
            }
        }
        return res;
    }
}
