package nowcoder.mianshijindian;

/**
 * Created by nick on 2017/6/25.
 */
public class MaxSum {
    public int getMaxSum(int[] A, int n) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            max = Math.max(sum, max);
            if (sum <= 0) {
                sum = 0;
            }
        }
        return max;
    }
}
