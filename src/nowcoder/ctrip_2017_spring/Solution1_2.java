package nowcoder.ctrip_2017_spring;

import java.util.Scanner;

/**
 * Created by nick on 2017/4/25.
 */
/**
 * 标准背包问题
 */
public class Solution1_2 {
    static int[][] path = new int[51][51];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int j = 0; j < 51; j++) {
            path[0][j] = 1;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            for (int j = 0; j <= n; j++) {
                if (j >= i && j <= sum) {
                    path[i][j] = Math.max(path[i - 1][j], path[i - 1][j - i] * i);
                } else {
                    path[i][j] = 1;
                }
            }
        }
        System.out.println(path[n][n]);
    }
}
