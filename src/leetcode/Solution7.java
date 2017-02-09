package leetcode;

/**
 * Created by nick on 2016/11/7.
 *
 * 思路很简单：变成字符串。
 * 需要考虑的问题：
 * 1. 反转后的数可能会越界，这时返回0；越界问题很关键！
 * 2. 10，100等末尾为0的数。
 *
 */
public class Solution7 {
    public int reverse(int x) {
        String s = String.valueOf(x);
        char[] c = s.toCharArray();
        int head = 0;
        int tail = c.length - 1;
        if (c[0] == '-') {
            head = 1;
        }
        char tmp;
        while(head < tail) {
            tmp = c[head];
            c[head] = c[tail];
            c[tail] = tmp;
            head++;
            tail--;
        }
        if (c[0] != '-') {
            char[] maxChar = String.valueOf(Integer.MAX_VALUE).toCharArray();
            if (c.length > maxChar.length) {
                return 0;
            } else if (c.length == maxChar.length) {
                if (compare(c, maxChar) > 0) {
                    return 0;
                }
            }
        } else {
            char[] minChar = String.valueOf(Integer.MIN_VALUE).toCharArray();
            if (c.length > minChar.length) {
                return 0;
            } else if (c.length == minChar.length) {
                if (compare(c, minChar) < 0) {
                    return 0;
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

    public static void main(String[] args) {
        Solution7 s = new Solution7();
        int r = s.reverse(0);
        System.out.println(r);
    }
}
