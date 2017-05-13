package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/1.
 */
public class Solution31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) {
            return 0;
        }
        int high, low, curr, tmp, i = 1;
        int count = 0;
        high = n;
        while (high != 0) {
            high = n / (int)Math.pow(10, i);
            tmp = n % (int)Math.pow(10, i);
            curr = tmp / (int)Math.pow(10, i - 1);
            low = tmp % (int)Math.pow(10, i - 1);
            if (curr < 1) {
                count += high * Math.pow(10, i - 1);
            } else if (curr == 1) {
                count += high * Math.pow(10, i - 1) + low + 1;
            } else {
                count += (high + 1) * Math.pow(10, i - 1);
            }
            i++;
        }
        return count;
    }
}
