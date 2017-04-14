package nowcoder.ctrip_2017_spring;

import java.util.Scanner;

/**
 * Created by nick on 2017/4/12.
 */
public class Solution1 {

    static int[][] path = new int[51][51];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int j = 0; j < 51; j++) {
            path[0][j] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                for (int k = 1; k < j; k++) {
                    path[i][j] = Math.max(path[i][j], path[i - j][k] * j);
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, path[n][i]);
        }
        System.out.println(max);
    }
}
