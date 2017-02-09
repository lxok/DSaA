package leetcode;

/**
 * Created by nick on 2016/12/19.
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        char[] c1 = haystack.toCharArray();
        char[] c2 = needle.toCharArray();
        if (c2.length == 0) {
            return 0;
        }
        if (c1.length == 0) {
            return -1;
        }
        int i1 = 0;
        int i2 = 0;
        for (; i1 < c1.length; i1++) {
            if (c1[i1] == c2[i2]) {
                i2++;
                if (i2 == c2.length) {
                    return i1 - c2.length + 1;
                }
            } else {
                i1 -= i2;
                i2 = 0;
            }
        }
        return  -1;
    }
}
