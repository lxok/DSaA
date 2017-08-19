package nowcoder.jianzhioffer2;

/**
 * Created by nick on 2017/7/9.
 */
public class S27 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count += array[i];
            max = Math.max(max, count);
            if (count < 0) {
                count = 0;
            }
        }
        return max;
    }
}
