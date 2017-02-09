package leetcode;

/**
 * Created by nick on 2017/1/3.
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {
        if (n < 0) {
            return null;
        }
        int[][] res = new int[n][n];
        if (n == 0) {
            return res;
        }
        int value = 1;
        int max = n * n;
        int direction = 0;
        int[][] path = new int[n][n];
        int i = 0;
        int j = 0;
        path[0][0] = -1;
        res[0][0] = 1;
        while (true) {
            if (direction == 0) {
                while (j + 1 < n && path[i][j + 1] != -1) {
                    j++;
                    path[i][j] = -1;
                    res[i][j] = ++value;
                }
                if (value >= max) {
                    return res;
                } else {
                    direction = 1;
                }
            } else if (direction == 1) {
                while (i + 1 < n && path[i + 1][j] != -1) {
                    i++;
                    path[i][j] = -1;
                    res[i][j] = ++value;
                }
                if (value >= max) {
                    return res;
                } else {
                    direction = 2;
                }
            } else if (direction == 2) {
                while (j - 1 > -1 && path[i][j - 1] != -1) {
                    j--;
                    path[i][j] = -1;
                    res[i][j] = ++value;
                } if (value >= max) {
                    return res;
                } else {
                    direction = 3;
                }
            } else if (direction == 3) {
                while (i - 1 > -1 && path[i - 1][j] != -1) {
                    i--;
                    path[i][j] = -1;
                    res[i][j] = ++value;
                } if (value >= max) {
                    return res;
                } else {
                    direction = 0;
                }
            }
        }
    }
}
