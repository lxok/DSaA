package nowcoder.jianzhioffer2;

import java.util.Arrays;

/**
 * Created by nick on 2017/7/9.
 */
public class S26 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Arrays.sort(array);
        int index = (array.length - 1 ) / 2;
        int val = array[index];
        int count = 1;
        for (int i = index + 1; i < array.length; i++) {
            if (array[i] == val) {
                count++;
            } else {
                break;
            }
        }
        for (int i = index - 1; i >= 0; i--) {
            if (array[i] == val) {
                count++;
            } else {
                break;
            }
        }
        return count > array.length / 2 ? val : 0;
    }
}
