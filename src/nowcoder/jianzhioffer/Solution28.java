package nowcoder.jianzhioffer;

import java.util.*;

/**
 * Created by nick on 2017/4/30.
 */
public class Solution28 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Arrays.sort(array);
        int val = array[array.length / 2];
        int count = 1;
        for (int i = val - 1; i >= 0; i--) {
            if (array[i] == val) {
                count++;
            } else {
                break;
            }
        }
        for (int i = val + 1; i < array.length; i++) {
            if (array[i] == val) {
                count++;
            } else {
                break;
            }
        }
        if (count >= array.length / 2 + 1) {
            return val;
        } else {
            return 0;
        }
    }
}
