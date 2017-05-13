package nowcoder.netease_2017_spring;

import java.util.Scanner;

/**
 * Created by nick on 2017/4/15.
 */
public class Solution7 {
    static int w;
    static int x;
    static int y;
    static int z;
    static int[][] p;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        w = s.nextInt();
        x = s.nextInt();
        y = s.nextInt();
        z = s.nextInt();
        p = new int[x - w + 1][z - y + 1];

        int count = 0;
        for (int i = w; i <= x; i++) {
            for (int j = y; j <= z; j++) {
                if (p[i - w][j - y] == 1) {
                    continue;
                }
                if (i % j == 0) {
                    invalid(i / j, 1);
                } else {
                    invalid(i, j);
                }
                count++;
            }
        }
        System.out.println(count);
    }

    static void invalid(int i, int j) {
        int k = 2;
        int iIndex = i;
        int jIndex = j;
        while (iIndex <= x && jIndex <= z) {
            p[iIndex - w][jIndex - y] = 1;
            iIndex = i * k;
            jIndex = j * k;
            k++;
        }
    }
}
