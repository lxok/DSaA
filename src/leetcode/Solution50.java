package leetcode;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2016/12/31.
 */
public class Solution50 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        long nl = n;
        if (nl < 0) {
            return 1.0 / myPow2(x, -nl);
        }
        return myPow2(x, nl);
    }

    public double myPow2(double x, long n) {
        if (x == 1) {
            return 1;
        }
        double res = x;
        List<Double> list = new ArrayList<>();
        while (n > 1) {
            if (n % 2 != 0) {
                list.add(res);
            }
            res = res * res;
            n /= 2;
        }
        for (int i = 0; i < list.size(); i++) {
            res *= list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution50 s = new Solution50();
        double res = s.myPow(2.00000, 5);
        System.out.println(res);
    }
}
