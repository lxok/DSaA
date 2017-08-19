package nowcoder.jianzhioffer2;

/**
 * Created by nick on 2017/7/4.
 */
public class S2 {
    public String replaceSpace(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            }  else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
