package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/4/25.
 */
public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        StringBuilder newStr = new StringBuilder();
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c != ' ') {
                newStr.append(c);
            } else {
                newStr.append("%20");
            }
        }
        return newStr.toString();
    }
}
