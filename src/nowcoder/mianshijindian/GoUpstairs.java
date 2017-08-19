package nowcoder.mianshijindian;

/**
 * Created by nick on 2017/6/17.
 */
public class GoUpstairs {
    public int countWays(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int[] val = new int[n + 1];
        val[1] = 1;
        val[2] = 2;
        val[3] = 4;
        for (int i = 4; i <= n; i++) {
            val[i] = ((val[i - 1] + val[i - 2]) % 1000000007 + val[i - 3]) % 1000000007;
        }
        return val[n];
    }
}
