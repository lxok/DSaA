package leetcode;

/**
 * Created by nick on 2017/1/7.
 */
public class Solution66 {
    public int[] plusOne(int[] digits) {
        int[] res;
        int i;
        for (i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                break;
            }
        }
        if (i == digits.length) {
            res = new int[digits.length + 1];
        } else {
            res = new int[digits.length];
        }
        int add = 0;
        int value;
        int index = res.length - 1;
        for (i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                value = digits[i] + add + 1;
            } else {
                value = digits[i] + add;
            }
            add = 0;
            if (value > 9) {
                add = 1;
                value -= 10;
            }
            res[index--] = value;
        }
        if (add == 1) {
            res[0] = 1;
        }
        return res;
    }
}
