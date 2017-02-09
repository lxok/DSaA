package leetcode;

/**
 * Created by nick on 2017/1/7.
 */
public class Solution69 {
    public int mySqrt(int x) {
        int medium;
        int high = x;
        int low = 0;
        int num;
        double max = Math.sqrt(Integer.MAX_VALUE);
        while (true) {
            if (high < max && high * high == x) {
               return high;
            }
            if (low * low == x) {
                return low;
            }
            if (high - low <= 1) {
                return low;
            }
            medium = (high + low) / 2;
            if (medium > max) {
                high = medium;
                continue;
            }
            num = medium * medium;
            if (num == x) {
                return medium;
            }
            if (num < x) {
                low = medium;
            }
            if (num > x) {
                high = medium;
            }
        }
    }

    public static void main(String[] args) {
        Solution69 s = new Solution69();
        System.out.println("/");
    }
}
