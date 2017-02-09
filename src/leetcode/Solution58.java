package leetcode;

/**
 * Created by nick on 2017/1/3.
 */
public class Solution58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] c = s.toCharArray();
        int length = 0;
        boolean startCount = true;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                startCount = true;
            } else {
                if (startCount) {
                    length = 1;
                    startCount = false;
                } else {
                    length++;
                }
            }
        }
        return length;
    }
}
