package nowcoder.mianshijindian;

/**
 * Created by nick on 2017/6/15.
 */
public class S29 {
    public int calcCost(int A, int B) {
        int s = A ^ B;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((s & 1) == 1) {
                res++;
            }
            s = s >>> 1;
        }
        return res;
    }
}
