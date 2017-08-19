package nowcoder.kinds_of;

import java.util.Scanner;

/**
 * Created by nick on 2017/7/12.
 */
public class S5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            if (m == 0 || n == 0) {
                System.out.println(0);
                continue;
            }
            int[][] matrix = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            System.out.println(apple(m, n, matrix));
        }
    }

    static int apple(int m, int n, int[][] matrix) {
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j - 1 >= 0 && i - 1 >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
                } else if (j - 1 >= 0) {
                    dp[i][j] = dp[i][j - 1] + matrix[i][j];
                } else if (i - 1 >= 0) {
                    dp[i][j] = dp[i - 1][j] + matrix[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
