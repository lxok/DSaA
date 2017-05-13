package leetcode;

/**
 * Created by nick on 2017/4/14.
 */
/**
 * 回文题经典题
 * dp解决字符串的回文问题
 * 同时再用另一个dp解决每一个点到边缘的最小回文数量
 * 两个的复杂度都是n^2, 可以同时在一次n^2循环里完成
 *
 * 两个dp都挺经典，这个题很受用！
 * 注意总结归纳不同dp问题的递推方程。
 */
public class Solution132 {
    int min = Integer.MAX_VALUE;
    boolean[][] path;

    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        path = new boolean[n][n];
        for (int k = 0; k < n; k++) {
            int i = k;
            int j = k;
            while (i >= 0 && j < n) {
                if (i == j) {
                    path[i][j] = true;
                } else {
                    path[i][j] = path[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
                i--;
                j++;
            }
        }
        for (int k = 0; k < n; k++) {
            int i = k;
            int j = k + 1;
            while (i >= 0 && j < n) {
                if (i + 1 == j) {
                    path[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    path[i][j] = path[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
                i--;
                j++;
            }
        }

        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = n - i;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (path[i][j]) {
                    if (j + 1 <= n - 1) {
                        dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                    } else {
                        dp[i] = 1;
                    }
                }
            }
        }
        return dp[0] - 1;
    }

    public static void main(String[] args) {
        Solution132 s = new Solution132();
        s.minCut("aab");
    }
}
