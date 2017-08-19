package nowcoder.jianzhioffer2;

/**
 * Created by nick on 2017/7/5.
 */
public class S12 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
