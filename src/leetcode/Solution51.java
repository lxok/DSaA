package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2017/1/1.
 */
public class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        int[][] b = new int[n][n];
        dfs(res, b, 0);
        return res;
    }

    public void dfs(List<List<String>> res, int[][] b, int level) {
        boolean sat;
        int n = b[0].length;
        for (int j = 0; j < b[0].length; j++) {
            sat = true;
            for (int i = 0; i < level; i++) {
                if (b[i][j] == 1) {
                    sat = false;
                    break;
                }
            }
            if (!sat) {
                continue;
            }
            int tmpJ = j;
            int tmpI = level;
            while (tmpJ + 1 < n && tmpI - 1 >= 0) {
                if (b[tmpI - 1][tmpJ + 1] == 1) {
                    sat = false;
                    break;
                }
                tmpJ++;
                tmpI--;
            }
            if (!sat) {
                continue;
            }
            tmpJ = j;
            tmpI = level;
            while (tmpJ - 1 >= 0 && tmpI - 1 >= 0) {
                if (b[tmpI - 1][tmpJ - 1] == 1) {
                    sat = false;
                    break;
                }
                tmpJ--;
                tmpI--;
            }
            if (!sat) {
                continue;
            }
            for (int k = 0; k < n; k++) {
                if (k == j) {
                    b[level][k] = 1;
                } else {
                    b[level][k] = 0;
                }
            }
            if (level == n - 1) {
                out(res, b);
            } else {
                dfs(res, b, level + 1);
            }
        }
    }

    public void out(List<List<String>> res, int[][] b) {
        int n = b[0].length;
        List<String> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            StringBuffer s = new StringBuffer();
            for (int j = 0; j < n; j++) {
                if (b[i][j] == 0) {
                    s.append(".");
                } else {
                    s.append(("Q"));
                }
            }
            list.add(s.toString());
        }
        res.add(list);
    }

    public static void main(String[] args) {
        Solution51 s  = new Solution51();
        s.solveNQueens(4);
    }
}
