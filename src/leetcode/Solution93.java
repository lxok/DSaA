package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2017/2/20.
 */
/**
 * 这道题我选用的是回溯
 */
public class Solution93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int length = s.length();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        char[] ca = s.toCharArray();
        dfs(res, "", ca, 0, 0);
        return res;
    }

    public void dfs(List<String> res, String string, char[] ca, int count, int startIndex ) {
        int length = ca.length;
        if (count == 4) {
            if (startIndex >= length) {
                res.add(string.substring(0, string.length() - 1));
            }
            return;
        }
        int remain = length - startIndex;
        if (remain > 0) {
            dfs(res, string + ca[startIndex] + ".", ca, count + 1, startIndex + 1);
        }
        if (remain > 1 && valid2(ca, startIndex)) {
            dfs(res, string + ca[startIndex] + ca[startIndex + 1] + ".", ca, count + 1, startIndex + 2);
        }
        if (remain > 2 && valid(ca, startIndex)) {
            dfs(res, string + ca[startIndex] + ca[startIndex + 1] + ca[startIndex + 2] + ".", ca, count + 1, startIndex + 3);
        }
    }

    public boolean valid(char[] ca, int startInddex) {
        if (ca[startInddex] == '0') {
            return false;
        }
        String tmp = "" + ca[startInddex] + ca[startInddex + 1] + ca[startInddex + 2];
        int value = Integer.parseInt(tmp);
        if (value <= 255) {
            return true;
        }
        return false;
    }

    public boolean valid2(char[] ca, int startInddex) {
        if (ca[startInddex] == '0') {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution93 s = new Solution93();
        s.restoreIpAddresses("0000");
    }
}
