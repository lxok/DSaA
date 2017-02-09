package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2016/12/17.
 */
/**
 * dfs, 注意剪枝
 */

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs(res, "(", n - 1, n);
        return res;
    }

    public void dfs(List<String> list, String s, int left, int right) {
        if (left > right) {
            return;
        }
        if (left == 0 & right == 0) {
            list.add(s);
            return;
        }
        if (left > 0) {
            dfs(list, s + "(", left - 1, right);
        }
        if (right > 0) {
            dfs(list, s + ")", left, right - 1);
        }
    }
}
