package nowcoder.jianzhioffer2;

import java.util.ArrayList;

/**
 * Created by nick on 2017/7/7.
 */
public class S20 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                flag[i][j] = true;
            }
        }
        int dir = 1;
        int x = 0;
        int y = 0;
        for (int i = 0; i < m * n; i++) {
            res.add(matrix[x][y]);
            flag[x][y] = false;
            if (dir == 1) {
                if (y + 1 <= n - 1 && flag[x][y + 1]) {
                    y++;
                } else {
                    x++;
                    dir = 2;
                }
            } else if (dir == 2) {
                if (x + 1 <= m - 1 && flag[x + 1][y]) {
                    x++;
                } else {
                    y--;
                    dir = 3;
                }

            } else if (dir == 3) {
                if (y - 1 >= 0 && flag[x][y - 1]) {
                    y--;
                } else {
                    x--;
                    dir = 4;
                }
            } else {
                if (x - 1 >= 0 && flag[x - 1][y]) {
                    x--;
                } else {
                    y++;
                    dir = 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        S20 s = new S20();
        s.printMatrix(new int[][]{{1,2},{3,4}});
    }
}
