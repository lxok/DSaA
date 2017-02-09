package leetcode;

/**
 * Created by nick on 2017/1/6.
 */
public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] up = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    up[i][j] = 0;
                } else {
                    if (i == 0 && j == 0) {
                        up[i][j] = 1;
                    } else if (i - 1 < 0) {
                        up[i][j] = up[i][j - 1];
                    } else if (j - 1 < 0) {
                        up[i][j] = up[i - 1][j];
                    } else {
                        up[i][j] = up[i - 1][j] + up[i][j - 1];
                    }
                }
            }
        }
        return up[m - 1][n - 1];
    }
}
