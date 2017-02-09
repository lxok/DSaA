package leetcode;

/**
 * Created by nick on 2016/11/7.
 *
 * 这个代码写的很shit，完全就是面向测试编程，修修补补，自己都不想读第二遍。
 * 其实测试点相对简单：
 * 1.空格清除
 * 2.数字前只能有一个符号，'+'或'-'
 * 3.数字可能越界，超过最大值显示最大值，超过最小值显示最小值。
 *
 */
public class Solution8 {
    public static void main(String[] args) {
        Solution8 s = new Solution8();
        int res = s.myAtoi("    +1146905820n1");
        System.out.println(res);
    }

    public int myAtoi(String str) {
        char[] c = str.trim().toCharArray();
        if (c.length == 0) {
            return 0;
        }
        if (!symbol(c[0])) {
            return 0;
        }
        if (c.length >= 2) {
            int i;
            for (i = 1; i < c.length; i++) {
                if (!digit(c[i])) {
                    break;
                }
            }
            if (i == 1) {
                if (digit(c[0])) {
                    return Integer.parseInt(String.valueOf(c[0]));
                } else {
                    return 0;
                }
            } else {
                c = String.valueOf(c).substring(0, i).toCharArray();
            }
        } else {
            if (!digit(c[0])) {
                return 0;
            }
        }
        System.out.println(c.length);
        if (c[0] != '-') {
            if (c[0] == '+') {
                c = String.valueOf(c).substring(1).toCharArray();
            }
            char[] maxChar = String.valueOf(Integer.MAX_VALUE).toCharArray();
            if (c.length > maxChar.length) {
                return Integer.MAX_VALUE;
            } else if (c.length == maxChar.length) {
                if (compare(c, maxChar) > 0) {
                    return Integer.MAX_VALUE;
                }
            }
        } else {
            char[] minChar = String.valueOf(Integer.MIN_VALUE).toCharArray();
            if (c.length > minChar.length) {
                return Integer.MIN_VALUE;
            } else if (c.length == minChar.length) {
                if (compare(c, minChar) < 0) {
                    return Integer.MIN_VALUE;
                }
            }
        }
        return Integer.parseInt(String.valueOf(c));
    }

    public int compare(char[] c1, char[] c2) {
        if (c1[0] != '-') {
            for (int i = 0; i < c1.length; i++) {
                if (c1[i] > c2[i]) {
                    return 1;
                } else if (c1[i] < c2[i]) {
                    return -1;
                }
            }
        } else {
            for (int i = 1; i < c1.length; i++) {
                if (c1[i] < c2[i]) {
                    return 1;
                }  else if (c1[i] > c2[i]) {
                    return -1;
                }
            }
        }
        return 0;
    }

    public boolean symbol(char c) {
        if (c == '-' || digit(c) || c == '+') {
            return true;
        }
            return false;
    }

    public boolean digit(char c) {
        if (c < '0' || c > '9') {
            return false;
        }
        return true;
    }
}
