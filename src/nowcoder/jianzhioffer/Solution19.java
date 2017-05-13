package nowcoder.jianzhioffer;

import java.util.ArrayList;

/**
 * Created by nick on 2017/4/27.
 */
public class Solution19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] flag = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                flag[i][j] = 0;
            }
        }
        int dire = 1;
        int i = 0;
        int j = 0;
        int count = 0;
        while (count < m * n) {
            res.add(matrix[i][j]);
            flag[i][j] = 1;
            count++;
            if (dire == 1) {
                if (j + 1 <= n - 1 && flag[i][j + 1] == 0) {
                    j++;
                } else {
                    dire = 2;
                    i++;
                }
            } else if (dire == 2) {
                if (i + 1 <= m - 1 && flag[i + 1][j] == 0) {
                    i++;
                } else {
                    dire = 3;
                    j--;
                }
            } else if (dire == 3) {
                if (j - 1 >= 0 && flag[i][j - 1] == 0) {
                    j--;
                } else {
                    dire = 4;
                    i--;
                }
            } else if (dire == 4) {
                if (i - 1 >= 0 && flag[i - 1][j] == 0) {
                    i--;
                } else {
                    dire = 1;
                    j++;
                }
            }
        }
        return res;
    }
}
