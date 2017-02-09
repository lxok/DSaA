package leetcode;

/**
 * Created by nick on 2016/12/29.
 */
/**
 * 注意char转int，直接转换会按照ASCII转换
 */
public class Solution43 {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "";
        }
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int[] res = new int[c1.length + c2.length];
        int next = 0;
        for(int i = 0; i < c1.length + c2.length; i++) {
            res[i] += next;
            next = 0;
            for (int j = 0; j <= i; j++) {
                if (c1.length - 1 - j >= 0 && c2.length - 1 - i + j >= 0 ) {
                    res[i] += Character.getNumericValue(c1[c1.length - 1 - j]) * Character.getNumericValue(c2[c2.length - 1 - i + j]);
                }
            }
            if (res[i] >= 10) {
                next += res[i] / 10;
                res[i] = res[i] % 10;
            }
        }

        String s = "";
        int index;
        for (index = res.length - 1; index >= 0; index--) {
            if (res[index] > 0) {
                break;
            }
        }
        if (index < 0) {
            return "0";
        } else {
            for (int k = index; k >= 0; k--) {
                s = s + res[k];
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Solution43 s = new Solution43();
        String res = s.multiply("0", "0");
        System.out.println(res);
    }
}
