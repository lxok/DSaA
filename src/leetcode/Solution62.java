package leetcode;

/**
 * Created by nick on 2017/1/5.
 */
/**
 * 蠢逼，上来直接用dfs树来做，一点都没想一下这么做的复杂度至少是2的m + n次，题设
 * 还要求m+n<=100，这么看来可能用这么高的复杂度吗？
 *
 * 这个题是典型的动态规划，而且递推公式十分简单清晰。
 */
public class Solution62 {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] up = new int[m][n];
        for (int j = 0; j < n; j++) {
            up[0][j] = 1;
        }
        for (int i = 0; i < m; i++) {
            up[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                up[i][j] = up[i - 1][j] + up[i][j - 1];
            }
        }
        return up[m - 1][n - 1];
    }
}
