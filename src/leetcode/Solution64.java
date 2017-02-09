package leetcode;

/**
 * Created by nick on 2017/1/7.
 */
public class Solution64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                sum += grid[0][i];
            }
            return sum;
        }
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                sum += grid[i][0];
            }
            return sum;
        }
        int[][] mp = new int[m][n];
        mp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            mp[0][i] = mp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            mp[i][0] = mp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                mp[i][j] = Math.min(mp[i - 1][j], mp[i][j - 1]) + grid[i][j];
            }
        }
        return mp[m - 1][n - 1];
    }
}
