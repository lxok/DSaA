package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2017/1/1.
 */
public class Solution52 {
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        List<Integer> res = new ArrayList<>();
        int[][] b = new int[n][n];
        dfs(res, b, 0);
        return res.size();
    }

    public void dfs(List<Integer> res, int[][] b, int level) {
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
                res.add(1);
            } else {
                dfs(res, b, level + 1);
            }
        }
    }
}
