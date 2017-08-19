package nowcoder.mianshijindian;

/**
 * Created by nick on 2017/6/1.
 */
public class S5 {
    public String zipString(String iniString) {
        if (iniString == null || iniString.length() == 0) {
            return iniString;
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int count = 1;
        for (int i = 0; i < iniString.length(); i++) {
            if (i + 1 < iniString.length() && iniString.charAt(i) == iniString.charAt(i + 1)) {
                flag = true;
                count++;
            } else {
                if (flag) {
                    sb.append(iniString.charAt(i));
                    sb.append(count);
                    flag = false;
                    count = 1;
                } else {
                    sb.append(iniString.charAt(i));
                    sb.append(1);
                }
            }
        }
        String n = sb.toString();
        return n.length() > iniString.length() ? iniString : n;
    }
}
