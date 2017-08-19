package nowcoder.mianshijindian;

/**
 * Created by nick on 2017/6/25.
 */
public class Rearrange {
    public int[] findSegment(int[] A, int n) {
        int[] res = new int[2];
        int end = -1;
        int tmpValue = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (A[i] >= tmpValue) {
                tmpValue = A[i];
            } else {
                end = i;
            }
        }
        int start = n - 1;
        tmpValue = Integer.MAX_VALUE;
        for (int j = n - 1; j >= 0; j--) {
            if (A[j] <= tmpValue) {
                tmpValue = A[j];
            }else {
                start = j;
            }
        }
        if (start < end) {
            res[0] = start;
            res[1] = end;
            return res;
        }
        res[0] = 0;
        res[1] = 0;
        return res;
    }
}
