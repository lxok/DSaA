package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/5.
 */
public class Solution49 {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] c = str.toCharArray();
        int flag = 0;
        int start = 0;
        if (c[start] == '+') {
            flag = 0;
            start++;
        } else if (c[start] == '-') {
            flag = 1;
            start++;
        }
        if (start == 1 && c.length == 1) {
            return 0;
        }
        long sum = 0;
        for (int i = start; i < c.length; i++) {
            if (c[i] >= '0' && c[i] <= '9') {
                sum += Character.getNumericValue(c[i]) * Math.pow(10, c.length - 1 - i);
            } else {
                return 0;
            }
        }
        if (sum > Integer.MAX_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (flag == 1 && sum != 0) {
            return (int)-sum;
        }
        return (int)sum;
    }


}
