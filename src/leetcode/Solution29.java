package leetcode;

/**
 * Created by nick on 2016/12/19.
 */
/**
 * 1. 使用Long型避免了int越界问题
 * 2. 平移即为乘除2的幂次
 */
public class Solution29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        int flag = -1;
        if (dividend < 0) {
            flag = -flag;
        }
        if (divisor < 0) {
            flag = -flag;
        }
        long tmp = Math.abs((long)dividend);
        long divisorLong = Math.abs((long)divisor);
        long tmp2 = divisorLong;
        long c = 1;
        while(tmp > tmp2) {
            tmp2 <<= 1;
            c <<= 1;
        }
        long result = 0;
        while(tmp >= divisorLong) {
            while(tmp >= tmp2) {
                tmp -= tmp2;
                result += c;
            }
            tmp2 >>= 1;
            c >>= 1;
        }
        if (flag > 0) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        Solution29 s = new Solution29();
        System.out.println(s.divide(-2147483648, -1));
    }
}
