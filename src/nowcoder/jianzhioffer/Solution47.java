package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/4.
 *
 * 牛逼
 */
public class Solution47 {
    public int Sum_Solution(int n) {
        boolean b = (n > 0) && ((n += Sum_Solution(n - 1)) > 0);
        return n;
    }
}
