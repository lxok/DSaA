package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2017/4/14.
 */
public class Solution131 {
    List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        List<String> list = new ArrayList<>();
        dfs(list, 0, s);
        return res;
    }

    void dfs(List<String> list, int index, String s) {
        if (index > s.length() - 1) {
            List<String> tmpList = new ArrayList<>();
            tmpList.addAll(list);
            res.add(tmpList);
            return;
        }

        int i = index;
        while (i <= s.length() - 1) {
            if (palin(s, index, i)) {
                list.add(s.substring(index, i + 1));
                dfs(list, i + 1, s);
                list.remove(list.size() - 1);
            }
            i++;
        }
    }

    boolean palin(String s, int start, int end) {
        if (start == end) {
            return true;
        }
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
