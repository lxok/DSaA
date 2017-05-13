package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/4/30.
 */
public class Solution30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (sum < 0) {
                sum = array[i];
            } else {
                sum += array[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
