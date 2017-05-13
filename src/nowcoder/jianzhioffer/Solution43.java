package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/4.
 *
 * 字符串翻转----先翻局部，后翻整体
 */
public class Solution43 {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int len = str.length();
        int k = n % len;
        char[] c = new char[len];
        int i = str.length() - 1;
        while (i >= 0) {
            if (i - k >= 0) {
                c[i - k] = str.charAt(i);
            } else {
                c[len - k + i] = str.charAt(i);
            }
            i--;
        }
        return String.valueOf(c);
    }

    public String LeftRotateString2(String str,int n) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int len = str.length();
        int k = n % len;
        if (k == 0) {
            return str;
        }
        char[] c = str.toCharArray();
        reverse(c, 0, k - 1);
        reverse(c, k, len - 1);
        reverse(c, 0, len - 1);
        return String.valueOf(c);
    }

    public void reverse(char[] c, int start, int end) {
        char tmp;
        while (start < end) {
            tmp = c[start];
            c[start] = c[end];
            c[end] = tmp;
            start++;
            end--;
        }
    }
}
