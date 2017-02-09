package leetcode;

/**
 * Created by nick on 2016/12/31.
 */
public class Solution48 {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int n = matrix[0].length;
        int firstBlock;
        boolean even;
        if (n % 2 == 0) {
            even = true;
        } else {
            even = false;
        }
        firstBlock = n / 2;
        int tmp;
        int tmp2;
        for (int i = 0; i < firstBlock; i++) {
            for (int j = 0; j < firstBlock; j++) {
                tmp = matrix[j][n - 1- i];
                matrix[j][n - 1 - i] = matrix[i][j];

                tmp2 = matrix[n - 1 - i][n - 1- j];
                matrix[n - 1 - i][n -1 - j] = tmp;
                tmp = tmp2;

                tmp2 = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = tmp;
                tmp = tmp2;

                matrix[i][j] = tmp;
            }
        }

        if (!even) {
            int medium = n / 2;
            int i = medium;
            for (int j = 0; j < medium; j++) {
                tmp = matrix[j][n - 1- i];
                matrix[j][n - 1 - i] = matrix[i][j];

                tmp2 = matrix[n - 1 - i][n - 1- j];
                matrix[n - 1 - i][n -1 - j] = tmp;
                tmp = tmp2;

                tmp2 = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = tmp;
                tmp = tmp2;

                matrix[i][j] = tmp;
            }
        }
    }
}
