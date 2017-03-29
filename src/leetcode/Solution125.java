package leetcode;

/**
 * Created by nick on 2017/3/19.
 */
public class Solution125 {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            while (!valid(begin, s)) {
                begin++;
            }
            while (!valid(end, s)) {
                end--;
            }
            if (begin < end) {
                if (Character.toLowerCase(s.charAt(begin)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
            }
            begin++;
            end--;
        }
        return true;
    }

    public boolean valid(int index, String s) {
        if (index < 0 || index > s.length() - 1) {
            return true;
        }
        char c = s.charAt(index);
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }
}
