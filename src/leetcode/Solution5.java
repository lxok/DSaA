package leetcode;

/**
 * Created by nick on 2016/11/6.
 *
 * 回文有两种：
 * 1. abcba
 * 2. abccba
 *
 * 1. 动态规划。
 * 2. 中心扩展。（选择） O(n^2)
 * 3. https://www.felix021.com/blog/read.php?2040
 *    一个O(n)算法，还没看懂。
 *
 *
 * 这道题前前后后写了一个多小时，还是已知解法的情况下。
 * 很多时间在于debug。原因是：1.写的不用心，变量写反。
 * 2.奇偶性问题，总想把两类问题放到一类解决，结果由于debug速度反倒被拖慢不少，
 * 以后在这类问题分割不清的情况下分开考虑，思路更加简单。
 *
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        int midRight = 0;
        int midLeft = 0;
        int len = 0;
        for (int i = 0; i < c.length; i++) {
            int len1 = getLen(c, i, i);
            int len2 = getLen(c, i, i + 1);
            if (len1 > len && len1 >= len2) {
                midRight = i;
                midLeft = i;
                len = len1;
            } else if (len2 > len && len1 < len2) {
                midLeft = i;
                midRight = i + 1;
                len = len2;
            }
        }
        return (midLeft == midRight) ? s.substring(midLeft - len/2, midRight + len/2 + 1):
                s.substring(midLeft - len/2 + 1, midRight + len/2);
    }

    public int getLen(char[] c, int left, int right) {
        int left2 = left;
        int right2 = right;
        int path = 0;
        while (left2 > -1 && right2 < c.length && c[left2] == c[right2]) {
            path++;
            left2--;
            right2++;
        }
        return (left == right) ? (2 * path - 1) : (2 * path);
    }


    public static void main(String[] args) {
        Solution5 s = new Solution5();
        String res = s.longestPalindrome("bbabb");
        System.out.println(res);
    }
}
