package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/4.
 *
 * 据说叫约瑟夫问题。
 */
public class Solution46 {
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        int s = 0;
        for (int i = 2; i <= n; i++) {
            s = (s + m) % i;
        }
        return s;
    }
}
