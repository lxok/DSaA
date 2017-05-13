package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/8.
 */
public class Solution53 {
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        int start = 0;
        if (str[0] == '-' || str[0] == '+') {
            if (str.length >= 2) {
                start = 1;
            } else {
                return false;
            }
        }
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = start; i < str.length; i++) {
            if (str[i] == '.') {
                if (eFlag || dotFlag || i == str.length - 1) {
                    return false;
                }
                dotFlag = true;
            } else if (str[i] == 'e' || str[i] == 'E') {
                if (eFlag || i == start || i == str.length - 1 || !isNum(str[i - 1])) {
                    return false;
                }
                eFlag = true;
            } else if (str[i] == '+' || str[i] == '-') {
                if (i == str.length - 1 || (str[i - 1] != 'e' && str[i - 1] != 'E')) {
                    return false;
                }
            } else if (!isNum(str[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isNum(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}
