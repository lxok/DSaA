package LintCode;

/**
 * Created by nick on 2017/7/18.
 */
public class S1 {
    public int digitCounts(int k, int n) {
        // write your code here
        int high = n;
        int low;
        int cur;
        int i = 1;
        int tmp;
        int count = 0;
        if (n == 0) {
            if (k == 0) {
                return 1;
            }
            return 0;
        }
        while(high > 0) {
            high = n / (int)Math.pow(10, i);
            tmp = n % (int)Math.pow(10, i);
            cur = tmp / (int)Math.pow(10, i - 1);
            low = tmp % (int)Math.pow(10, i - 1);

            if (cur < k) {
                count += high * (int)Math.pow(10, i - 1);
            } else if (cur == k) {
                count += high * (int)Math.pow(10, i - 1) + low + 1;
            } else {
                if (high == 0 && k == 0) {

                } else {
                    count += (high + 1) * (int)Math.pow(10, i - 1);
                }
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        S1 s = new S1();
        int res = s.digitCounts(0, 0);
        System.out.println(res);
    }
}
