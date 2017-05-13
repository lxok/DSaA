package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/7.
 *
 * O(N)
 * 循环两次，
 * 一次从头到尾，
 * 一次从尾到头。
 */
public class Solution51 {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int[] res = new int[A.length];
        int tmp = 1;
        res[0] = tmp;
        for (int i = 1; i < A.length; i++) {
            res[i] = res[i - 1] * A[i - 1];
        }
        for (int i = A.length - 2; i >= 0; i--) {
            tmp *= A[i + 1];
            res[i] *= tmp;
        }
        return res;
    }
}
