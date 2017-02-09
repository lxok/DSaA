package leetcode;

/**
 * Created by acer on 2017/1/31.
 */
public class Solution91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] c = s.toCharArray();
        if (c.length == 1) {
            int res = Character.getNumericValue(c[0]);
            if (res != 0 ) {
                return 1;
            }
            return 0;
        }
        int[] res = new int[c.length];
        int value = Character.getNumericValue(c[0]);
        if (value == 0) {
            res[0] = 0;
        } else {
            res[0] = 1;
        }
        value = Character.getNumericValue(c[1]);
        if (value == 0) {
            res[1] = 0;
        } else {
            res[1] = 1;
        }
        System.out.println(res[1]);
        if (seq(c, 1)) {
            res[1]++;
            //System.out.println(res[1]);
        }
        for (int i = 2; i < c.length; i++) {
            if (seq(c, i)) {
                res[i] = res[i - 2] + res[i - 1];
            } else {
                res[i] = res[i - 1];
                if (res[i] == 0 && Character.getNumericValue(c[i]) != 0) {
                    res[i]++;
                }
            }
        }
        return res[res.length - 1];
    }

    public boolean seq(char[] c, int i) {
        if (c[i - 1] == '1') {
            return true;
        }
        if (c[i - 1] == '2' && c[i] >= '0' && c[i] <= '6') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution91 s = new Solution91();
        s.numDecodings("01");
    }
}
