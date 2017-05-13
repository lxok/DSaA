package test;

/**
 * Created by nick on 2017/4/30.
 */
public class SFR {
    public static void main(String[] args) {
        int g = Integer.valueOf(args[0]);
        int a = Integer.valueOf(args[1]);
        int b = Integer.valueOf(args[2]);
        int k = Integer.valueOf(args[3]);

        int[][][] d = new int[g + 1][k + 1][k + 1];
        for (int i = 0; i < g + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                for (int t = 0; t < k + 1; t++) {
                    d[i][j][t] = 0;
                }
            }
        }
        d[0][0][0] = 1;
        int min = Integer.MAX_VALUE;
        int x = 0;
        int y = 0;
        int z = 0;
        for (int i = 1; i <= g; i++) {
            for (int j = i; j <= k; j++) {
                for (int t = 1; t <= j; t++) {
                    for (int l = 0; l <= t; l++) {
                        d[i][j][t] += d[i - 1][j - t][l];
                    }
                    if (t <= g && d[i][k][t] > 0 && i * a + t * b < min) {
                        x = i;
                        y = j;
                        z = t;
                        min = i * a + t * b;
                    }
                }
            }
        }
        System.out.println("Res:" + min);
        System.out.println("x:" + x + ", y:" + y + ", z:" + z);
    }
}
