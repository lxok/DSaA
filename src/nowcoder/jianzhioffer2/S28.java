package nowcoder.jianzhioffer2;

/**
 * Created by nick on 2017/7/9.
 */
public class S28 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) {
            return 0;
        }
        int high, low, cur, i = 1;
        int tmp;
        high = n;
        int count = 0;
        while (high != 0) {
            high = n / (int)Math.pow(10, i);
            tmp = n % (int)Math.pow(10, i);
            cur = tmp / (int)Math.pow(10, i - 1);
            low = tmp % (int)Math.pow(10, i - 1);
            if (cur < 1) {
                count += high * Math.pow(10, i - 1);
            } else if (cur == 1) {
                count += high * Math.pow(10, i - 1) + low + 1;
            } else {
                count += (high + 1) * Math.pow(10, i - 1);
            }
            i++;
        }
        return count;
    }
}
