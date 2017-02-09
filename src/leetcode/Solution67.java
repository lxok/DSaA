package leetcode;

/**
 * Created by nick on 2017/1/7.
 */
public class Solution67 {
    public String addBinary(String a, String b) {
        String res = "";
        if (a == null) {
            if (b == null) {
                return res;
            }
            return b;
        }
        if (b == null) {
            return a;
        }
        char[] m = a.toCharArray();
        char[] n = b.toCharArray();
        if (m.length == 0) {
            return b;
        }
        if (n.length == 0) {
            return a;
        }
        int mi = m.length - 1;
        int ni = n.length - 1;
        int add = 0;
        int value;
        while (mi >= 0 && ni >= 0) {
            value = Character.getNumericValue(m[mi--]) + Character.getNumericValue(n[ni--]) + add;
            add = 0;
            if (value == 2) {
                value = 0;
                add = 1;
            } else if (value == 3) {
                value = 1;
                add = 1;
            }
            res = value + res;
        }
        if (mi < 0) {
            for (int i = ni; i >= 0; i--) {
                value =  Character.getNumericValue(n[i]) + add;
                add = 0;
                if (value == 2) {
                    value = 0;
                    add = 1;
                }
                res = value + res;
            }
        }
        if (ni < 0) {
            for (int i = mi; i >= 0; i--) {
                value =  Character.getNumericValue(m[i]) + add;
                add = 0;
                if (value == 2) {
                    value = 0;
                    add = 1;
                }
                res = value + res;
            }
        }
        if (add == 1) {
            res = "1" + res;
        }
        return res;
    }
}
