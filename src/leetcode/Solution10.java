package leetcode;

/**
 * Created by nick on 2016/11/9.
 */
public class Solution10 {
    /*
    public boolean isMatch(String s, String p) {
        char[] sa = s.toCharArray();
        char[] pa = p.toCharArray();
        if (sa.length == 0 || pa.length == 0) {
            if (sa.length == 0 && pa.length == 0) {
                return true;
            } else {
                return false;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < pa.length; i++) {
            if (pa[i] == '*') {
                if (i - 1 < 0) {
                    return false;
                }
                char pri = pa[i - 1];
                if (pri == '*') {
                    return false;
                }
                int j = i + 1;
                if (pri != '.' && j < pa.length) {
                    while (j < pa.length && pri == pa[j]) {
                        j++;
                    }
                    if (j == pa.length) {
                        sb.append(pa[i]);
                    } else {
                        i = j - 1;
                    }
                }
            } else {
                sb.append(i);
            }
        }
        pa = sb.toString().toCharArray();
        int saindex = 0;
        char dotFlag = ' ';
        char starFlag = ' ';
        for (int i = 0; i < pa.length; i++) {
            if (pa[i] == '.' ) {
                if (i + 1 != pa.length && pa[i + 1] == '*') {
                    dotFlag = sa[saindex++];
                    while ()
                } else {
                    dotFlag = sa[saindex++];
                }
            } else
        }
        return false;
    }
*/

    public static void main(String[] args) {

    }
}
