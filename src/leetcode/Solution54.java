package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2017/1/2.
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int direction = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] path = new int[m][n];
        int i = 0;
        int j = 0;
        path[i][j] = -1;
        res.add(matrix[i][j]);
        while (true) {
            if (direction == 0) {
                while (j + 1 < n && path[i][j + 1] != -1) {
                    j++;
                    path[i][j] = -1;
                    res.add(matrix[i][j]);
                }
                if (i + 1 < m && path[i + 1][j] != -1) {
                    direction = 1;
                } else {
                    break;
                }
            } else if (direction == 1) {
                while (i + 1 < m && path[i + 1][j] != -1) {
                    i++;
                    path[i][j] = -1;
                    res.add(matrix[i][j]);
                }
                if (j - 1 > -1 && path[i][j - 1] != -1) {
                    direction = 2;
                } else {
                    break;
                }
            } else if (direction == 2) {
                while (j - 1 > -1 && path[i][j - 1] != -1) {
                    j--;
                    path[i][j] = -1;
                    res.add(matrix[i][j]);
                }
                if (i - 1 > -1 && path[i - 1][j] != -1) {
                    direction = 3;
                }
                else {
                    break;
                }
            } else if (direction == 3) {
                while (i - 1 > -1 && path[i - 1][j] != -1) {
                    i--;
                    path[i][j] = -1;
                    res.add(matrix[i][j]);
                }
                if (j + 1 < n && path[i][j + 1] != -1) {
                    direction = 0;
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] path = new int[3][2];
        System.out.println(path.length);
        System.out.println(path[0].length);
    }
}
