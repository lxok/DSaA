package leetcode;

/**
 * Created by nick on 2017/3/13.
 */
/**
 * 经典字符串dp问题
 * 可气的是明明知道是dp,就是不知道递推公式是啥
 * 原因在于自己的想法钻了牛角尖
 * 想考虑简单直接情况case,复杂case和corner case用推出来的算法验证，而不要一上来就用复杂case推公式，这样做太他么难了！！
 *
 * 最最主要原因还是自己对dp和字符串理解不够，以后多多练习
 */
public class Solution115 {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        if (s.length() == 0) {
            if (t.length() == 0) {
                return 1;
            }
            return 0;
        }
        if (t.length() == 0) {
            return 1;
        }
        int slen = s.length();
        int tlen = t.length();
        if (slen < tlen) {
            return 0;
        }
        int[][] record = new int[slen + 1][tlen + 1];
        for (int i = 1; i <= slen; i++) {
            record[i][0] = 1;
        }
        for (int j = 1; j <= tlen; j++) {
            record[0][j] = 0;
        }
        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= tlen; j++) {
                if (j > i) {
                    record[i][j] = 0;
                }
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    record[i][j] = record[i - 1][j] + record[i - 1][j - 1];
                } else {
                    record[i][j] = record[i - 1][j];
                }
            }
        }
        return record[slen][tlen];
    }
}
