package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/2.
 */
public class Solution34 {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int[] flag = new int[128];
        for (int i = 0; i < flag.length; i++) {
            flag[i] = 0;
        }
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            flag[c]++;
        }
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if ( flag[c] == 1 ) {
                return i;
            }
        }
        return -1;
    }
}
