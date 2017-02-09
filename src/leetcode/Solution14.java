package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by nick on 2016/11/22.
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        List s = new ArrayList<char[]>(strs.length);
        for (int i = 0; i < strs.length; i++) {
            s.add(strs[i].toCharArray());
        }
        int index = 0;
        Set e = new HashSet();
        char[] c;
        boolean b = false;
        while (true) {
            for (int i = 0; i < s.size(); i++) {
                c = (char[]) s.get(i);
                if (index < c.length) {
                    e.add(c[index]);
                } else {
                    b = true;
                    break;
                }
            }
            if (b) {
                break;
            }
            if (e.size() == 1) {
                index++;
                e.clear();
            } else {
                break;
            }
        }
        int res = index - 1;
        if (res >= 0) {
            return strs[0].substring(0, res + 1);
        } else {
            return "";
        }
    }
}
