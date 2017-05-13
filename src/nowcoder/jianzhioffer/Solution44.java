package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/4.
 *
 * 字符串翻转----先翻局部，后翻整体
 */
public class Solution44 {
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] c = str.toCharArray();
        int start = -1;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                if (start == -1) {
                    reverse(c, 0, i - 1);
                } else {
                    reverse(c, start + 1, i - 1);
                }
                start = i;
            }
        }
        reverse(c, start + 1, c.length - 1);
        reverse(c, 0, c.length - 1);
        return String.valueOf(c);
    }

    public void reverse(char[] c, int start, int end) {
        char tmp;
        while (start >= 0 && end < c.length && start < end) {
            tmp = c[start];
            c[start] = c[end];
            c[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution44 s = new Solution44();
        s.ReverseSentence("student. a am I");
    }
}
