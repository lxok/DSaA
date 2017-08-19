package nowcoder.mianshijindian;

/**
 * Created by nick on 2017/6/1.
 */
public class S1 {
    public String reverseString(String iniString) {
        if (iniString == null || iniString.length() == 0) {
            return iniString;
        }
        char[] c = iniString.toCharArray();
        int s = 0, e = c.length - 1;
        char t;
        while (s < e) {
            t = c[s];
            c[s] = c[e];
            c[e] = t;
            s++;
            e--;
        }
        return String.valueOf(c);
    }
}
